package com.example.MoneyMind.mappers;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.MoneyMind.dtos.MovementTypeRequestDTO;
import com.example.MoneyMind.dtos.MovementTypeResponseDTO;
import com.example.MoneyMind.entities.MovementType;

@Component
public class MovementTypeMapper {

    public MovementType toEntity(MovementTypeRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        return MovementType.builder()
                .typeName(dto.getTypeName())
                .build();
    }

    public MovementTypeResponseDTO toResponseDTO(MovementType movementType) {
        if (movementType == null) {
            return null;
        }

        return MovementTypeResponseDTO.builder()
                .idMovementType(movementType.getIdMovementType())
                .typeName(movementType.getTypeName())
                .build();
    }

    public List<MovementTypeResponseDTO> toResponseDTOList(List<MovementType> movementTypes) {
        if (movementTypes == null) {
            return null;
        }

        return movementTypes.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
