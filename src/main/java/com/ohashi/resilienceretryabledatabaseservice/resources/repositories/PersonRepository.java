package com.ohashi.resilienceretryabledatabaseservice.resources.repositories;

import com.ohashi.resilienceretryabledatabaseservice.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface PersonRepository extends JpaRepository<Person, UUID> {

    Optional<Person> findByCpf(String cpf);
}
