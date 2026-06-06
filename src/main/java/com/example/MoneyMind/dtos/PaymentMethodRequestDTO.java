package com.example.MoneyMind.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMethodRequestDTO {

    @NotBlank(message = "El nombre del método de pago es obligatorio")
    @Size(max = 50, message = "El nombre del método de pago no puede superar los 50 caracteres")
    private String methodName;
}