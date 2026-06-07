package com.example.MoneyMind.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
public class BudgetRequestDTO {

    @NotNull(message = "El id del usuario es requerido")
    private Integer idUsuario;

    @NotNull(message = "El id de la categoría es requerido")
    private Integer idCategory;

    @NotNull(message = "El monto límite es requerido")
    @DecimalMin(value = "0.01", message = "El monto límite debe ser mayor a 0")
    @Digits(integer = 10, fraction = 2, message = "El monto límite debe tener como máximo 2 decimales")
    private BigDecimal limitAmount;

    @NotNull(message = "El mes es requerido")
    @Min(value = 1, message = "El mes debe estar entre 1 y 12")
    @Max(value = 12, message = "El mes debe estar entre 1 y 12")
    private Integer month;

    @NotNull(message = "El año es requerido")
    @Min(value = 1900, message = "El año debe ser mayor o igual a 1900")
    private Integer year;
}
