package com.example.MoneyMind.mappers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.MoneyMind.dtos.MovementRequestDTO;
import com.example.MoneyMind.dtos.MovementResponseDTO;
import com.example.MoneyMind.entities.Category;
import com.example.MoneyMind.entities.Movement;
import com.example.MoneyMind.entities.PaymentMethod;

@Component
public class MovementMapper {

    public Movement toEntity(MovementRequestDTO dto, Category category, PaymentMethod paymentMethod) {
        if (dto == null) return null;

        return Movement.builder()
                .idUsuario(dto.getIdUsuario())
                .category(category)
                .paymentMethod(paymentMethod)
                .amount(dto.getAmount())
                .description(dto.getDescription())
                .transactionDate(dto.getTransactionDate())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public MovementResponseDTO toResponseDTO(Movement transaction) {
        if (transaction == null) return null;

        return MovementResponseDTO.builder()
                .idTransaction(transaction.getIdTransaction())
                .idUsuario(transaction.getIdUsuario())
                .idCategory(transaction.getCategory().getIdCategory())
                .categoryName(transaction.getCategory().getCategoryName())
                .idPaymentMethod(transaction.getPaymentMethod().getIdPaymentMethod())
                .paymentMethodName(transaction.getPaymentMethod().getMethodName())
                .amount(transaction.getAmount())
                .description(transaction.getDescription())
                .transactionDate(transaction.getTransactionDate())
                .createdAt(transaction.getCreatedAt())
                .build();
    }

    public List<MovementResponseDTO> toResponseDTOList(List<Movement> transactions) {
        if (transactions == null) return null;
        return transactions.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }
}
