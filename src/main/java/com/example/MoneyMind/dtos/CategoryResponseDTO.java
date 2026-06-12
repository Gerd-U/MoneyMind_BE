package com.example.MoneyMind.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDTO {

    private Integer idCategory;
    private Integer idUsuario;
    private Integer idMovementType;
    private String movementTypeName;
    private String categoryName;
    private String description;
    private Boolean active;
}
