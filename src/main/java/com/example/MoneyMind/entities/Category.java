package com.example.MoneyMind.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_movimiento", nullable = false)
    private MovementType movementType;

    @Column(name = "nombre_categoria", nullable = false, length = 50)
    private String categoryName;

    @Column(name = "descripcion", length = 100)
    private String description;

    @Column(name = "estado_categoria", nullable = false)
    private Boolean active;
}