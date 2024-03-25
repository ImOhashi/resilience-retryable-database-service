package com.ohashi.resilienceretryabledatabaseservice.domain.services;

import com.ohashi.resilienceretryabledatabaseservice.application.controllers.dto.PersonDTO;
import com.ohashi.resilienceretryabledatabaseservice.domain.entities.Person;

public interface PersonService {
    Person create(PersonDTO newPerson) throws Exception;
}
