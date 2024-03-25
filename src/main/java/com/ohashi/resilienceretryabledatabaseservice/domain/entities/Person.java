package com.ohashi.resilienceretryabledatabaseservice.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.stereotype.Indexed;

import java.util.UUID;

@Entity
public class Person {

    private Person(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.cpf = builder.cpf;
    }

    public Person(UUID id, String name, String description, String cpf) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cpf = cpf;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;
    private String cpf;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCpf() {
        return cpf;
    }

    public static class Builder {
        private String name;
        private String description;
        private String cpf;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
