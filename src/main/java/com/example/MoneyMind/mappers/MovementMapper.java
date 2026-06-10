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
                .movementDate(dto.getMovementDate())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public MovementResponseDTO toResponseDTO(Movement movement) {
        if (movement == null) return null;

        return MovementResponseDTO.builder()
                .idMovement(movement.getIdMovement())
                .idUsuario(movement.getIdUsuario())
                .idCategory(movement.getCategory().getIdCategory())
                .categoryName(movement.getCategory().getCategoryName())
                .idPaymentMethod(movement.getPaymentMethod().getIdPaymentMethod())
                .paymentMethodName(movement.getPaymentMethod().getMethodName())
                .amount(movement.getAmount())
                .description(movement.getDescription())
                .movementDate(movement.getMovementDate())
                .createdAt(movement.getCreatedAt())
                .build();
    }

    public List<MovementResponseDTO> toResponseDTOList(List<Movement> movements) {
        if (movements == null) return null;
        return movements.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }
}
