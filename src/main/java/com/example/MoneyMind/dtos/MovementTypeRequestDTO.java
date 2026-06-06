package com.example.MoneyMind.dtos;

import jakarta.validation.constraints.NotBlank;
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
public class MovementTypeRequestDTO {

    @NotBlank(message = "El nombre del tipo de movimiento es obligatorio")
    @Size(max = 20, message = "El nombre del tipo de movimiento no puede superar los 20 caracteres")
    private String typeName;
}
