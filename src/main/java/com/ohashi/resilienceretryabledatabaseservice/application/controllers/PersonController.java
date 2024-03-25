package com.ohashi.resilienceretryabledatabaseservice.application.controllers;

import com.ohashi.resilienceretryabledatabaseservice.application.controllers.dto.PersonDTO;
import com.ohashi.resilienceretryabledatabaseservice.domain.entities.Person;
import com.ohashi.resilienceretryabledatabaseservice.domain.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody PersonDTO newPerson) throws Exception {
        return ResponseEntity.ok(personService.create(newPerson));
    }
}
