package com.ohashi.resilienceretryabledatabaseservice.domain.exception;

public class PersonAlreadyExistsException extends Exception {
    public PersonAlreadyExistsException(String message) {
        super(message);
    }
}
