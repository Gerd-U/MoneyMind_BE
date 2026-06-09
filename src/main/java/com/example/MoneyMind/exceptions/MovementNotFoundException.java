package com.example.MoneyMind.exceptions;

public class MovementNotFoundException extends RuntimeException {
    public MovementNotFoundException(String message) {
        super(message);
    }
}
