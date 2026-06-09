package com.example.MoneyMind.models;

import java.time.LocalDateTime;

public record UserResponseModel(
        String firstName,
        String lastName,
        String email,
        LocalDateTime registrationDate,
        Boolean active) {

}