package com.example.MoneyMind.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Movimiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovement;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "monto", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "descripcion", length = 200)
    private String description;

    @Column(name = "fecha_movimiento", nullable = false)
    private LocalDate movementDate;

    @Column(name = "fecha_registro")
    private LocalDateTime createdAt;
}
