package com.example.MoneyMind.dtos;

import java.time.LocalDateTime;

public record UserDto(
        Integer id,
        String firstName,
        String lastName,
        String email,
        LocalDateTime registrationDate,
        Boolean active) {

}