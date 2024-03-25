package com.ohashi.resilienceretryabledatabaseservice.application.controllers.dto;

public class PersonDTO {

    public PersonDTO(String name, String description, String cpf) {
        this.name = name;
        this.description = description;
        this.cpf = cpf;
    }

    private String name;
    private String description;
    private String cpf;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
}
