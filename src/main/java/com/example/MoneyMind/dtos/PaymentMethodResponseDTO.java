package com.example.MoneyMind.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMethodResponseDTO {

    private Integer idPaymentMethod;
    private String methodName;
}