package com.example.MoneyMind.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryRequestDTO {

    @NotNull(message = "El tipo de movimiento es obligatorio")
    private Integer idMovementType;

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    @Size(max = 50, message = "El nombre de la categoría no puede superar los 50 caracteres")
    private String categoryName;

    @Size(max = 100, message = "La descripción no puede superar los 100 caracteres")
    private String description;

    @NotNull(message = "El estado de la categoría es obligatorio")
    private Boolean active;
}