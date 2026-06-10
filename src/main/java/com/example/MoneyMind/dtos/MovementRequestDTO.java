package com.example.MoneyMind.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementRequestDTO {

    @NotNull(message = "The user id is required")
    private Integer idUsuario;

    @NotNull(message = "The category id is required")
    private Integer idCategory;

    @NotNull(message = "The payment method id is required")
    private Integer idPaymentMethod;

    @NotNull(message = "The amount is required")
    @DecimalMin(value = "0.01", message = "The amount must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "The amount must have at most 2 decimals")
    private BigDecimal amount;

    @Size(max = 200, message = "The description cannot exceed 200 characters")
    private String description;

    @NotNull(message = "The movement date is required")
    private LocalDate movementDate;
}
