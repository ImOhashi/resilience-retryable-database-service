package com.ohashi.resilienceretryabledatabaseservice.domain.services.impl;

import com.ohashi.resilienceretryabledatabaseservice.application.controllers.dto.PersonDTO;
import com.ohashi.resilienceretryabledatabaseservice.domain.entities.Person;
import com.ohashi.resilienceretryabledatabaseservice.domain.exception.PersonAlreadyExistsException;
import com.ohashi.resilienceretryabledatabaseservice.domain.services.PersonService;
import com.ohashi.resilienceretryabledatabaseservice.resources.repositories.PersonRepository;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final KafkaTemplate kafkaTemplate;

    public PersonServiceImpl(PersonRepository personRepository, KafkaTemplate kafkaTemplate) {
        this.personRepository = personRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Retry(name = "createPersonRetry", fallbackMethod = "sentToRetryDatabaseTopic")
    public Person create(PersonDTO newPerson) throws Exception {
        try {
            var person = new Person.Builder()
                    .setName(newPerson.getName())
                    .setDescription(newPerson.getDescription())
                    .setCpf(newPerson.getCpf())
                    .build();

            if (personRepository.findByCpf(person.getCpf()).isPresent()) {
                throw new PersonAlreadyExistsException("Person already exists.");
            }

            return personRepository.save(person);
        } catch (Exception e) {
            throw new Exception("Error on save person=" + newPerson.getName());
        }
    }

    public Person sentToRetryDatabaseTopic(PersonDTO newPerson, Exception e) {
        kafkaTemplate.send("retry-database-topic", newPerson);

        return new Person.Builder()
                .setName(newPerson.getName())
                .setDescription(newPerson.getDescription())
                .setCpf(newPerson.getCpf())
                .build();
    }
}
