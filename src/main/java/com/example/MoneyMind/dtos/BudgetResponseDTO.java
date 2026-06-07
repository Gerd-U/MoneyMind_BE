package com.example.MoneyMind.dtos;

import java.math.BigDecimal;
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
public class BudgetResponseDTO {

    private Integer idBudget;
    private Integer idUsuario;
    private Integer idCategory;
    private String categoryName;
    private BigDecimal limitAmount;
    private Integer month;
    private Integer year;
    private LocalDateTime createdAt;
}
