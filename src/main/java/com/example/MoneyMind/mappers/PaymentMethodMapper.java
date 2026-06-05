package com.example.MoneyMind.mappers;

import com.example.MoneyMind.dtos.PaymentMethodRequestDTO;
import com.example.MoneyMind.dtos.PaymentMethodResponseDTO;
import com.example.MoneyMind.entities.PaymentMethod;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentMethodMapper {

    public PaymentMethod toEntity(PaymentMethodRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        return PaymentMethod.builder()
                .methodName(dto.getMethodName())
                .build();
    }

    public PaymentMethodResponseDTO toResponseDTO(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            return null;
        }

        return PaymentMethodResponseDTO.builder()
                .idPaymentMethod(paymentMethod.getIdPaymentMethod())
                .methodName(paymentMethod.getMethodName())
                .build();
    }

    public List<PaymentMethodResponseDTO> toResponseDTOList(List<PaymentMethod> paymentMethods) {
        if (paymentMethods == null) {
            return null;
        }

        return paymentMethods.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}