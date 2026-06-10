package com.example.MoneyMind.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class MovementResponseDTO {

    private Integer idMovement;
    private Integer idUsuario;
    private Integer idCategory;
    private String categoryName;
    private Integer idPaymentMethod;
    private String paymentMethodName;
    private BigDecimal amount;
    private String description;
    private LocalDate movementDate;
    private LocalDateTime createdAt;
}
