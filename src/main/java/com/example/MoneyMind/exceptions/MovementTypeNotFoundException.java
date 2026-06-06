package com.example.MoneyMind.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovementTypeNotFoundException extends RuntimeException {

    public MovementTypeNotFoundException(String message) {
        super(message);
    }
}