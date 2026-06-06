package com.example.MoneyMind.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Tipo_Movimiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name= "id_tipo_movimiento")
    private Integer idMovementType;

    @Column (name= "nombre_tipo", nullable= false, length= 20)
    private String typeName;
    
}
