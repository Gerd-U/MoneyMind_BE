package com.example.MoneyMind.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Metodo_Pago")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo_pago")
    private Integer idPaymentMethod;

    @Column(name = "nombre_metodo", nullable = false, length = 50)
    private String methodName;
}
