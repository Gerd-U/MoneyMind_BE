package com.example.MoneyMind.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Tipo_Movimiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_movimiento")
    private Integer idMovementType;

    @Column(name = "nombre_tipo", nullable = false, length = 20)
    private String typeName;
}