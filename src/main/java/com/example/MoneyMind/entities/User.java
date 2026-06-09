package com.example.MoneyMind.entities;

import java.time.LocalDateTime;

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
@Table(name = "usuario")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String firstName;

    @Column(name = "apellido", nullable = false, length = 50)
    private String lastName;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "contrasena", nullable = false, length = 255)
    private String password;

    @Column(name = "fecha_registro")
    private LocalDateTime registrationDate;

    @Column(name = "estado_usuario", nullable = false)
    private Boolean active;
}