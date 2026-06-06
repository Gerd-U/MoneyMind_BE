package com.example.MoneyMind.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.MoneyMind.dtos.MovementTypeRequestDTO;
import com.example.MoneyMind.dtos.MovementTypeResponseDTO;
import com.example.MoneyMind.entities.MovementType;
import com.example.MoneyMind.mappers.MovementTypeMapper;
import com.example.MoneyMind.services.IMovementTypeService;

@Component
public class MovementTypeFacade implements IMovementTypeFacade {

    private final IMovementTypeService movementTypeService;
    private final MovementTypeMapper movementTypeMapper;

    public MovementTypeFacade(IMovementTypeService movementTypeService,
                              MovementTypeMapper movementTypeMapper) {
        this.movementTypeService = movementTypeService;
        this.movementTypeMapper = movementTypeMapper;
    }

    @Override
    public MovementTypeResponseDTO save(MovementTypeRequestDTO requestDTO) {
        MovementType movementType = movementTypeMapper.toEntity(requestDTO);
        MovementType savedMovementType = movementTypeService.save(movementType);

        return movementTypeMapper.toResponseDTO(savedMovementType);
    }

    @Override
    public List<MovementTypeResponseDTO> getAll() {
        List<MovementType> movementTypes = movementTypeService.getAll();

        return movementTypeMapper.toResponseDTOList(movementTypes);
    }

    @Override
    public MovementTypeResponseDTO getById(Integer id) {
        MovementType movementType = movementTypeService.getById(id);

        return movementTypeMapper.toResponseDTO(movementType);
    }

    @Override
    public MovementTypeResponseDTO update(Integer id, MovementTypeRequestDTO requestDTO) {
        MovementType movementType = movementTypeMapper.toEntity(requestDTO);
        MovementType updatedMovementType = movementTypeService.update(id, movementType);

        return movementTypeMapper.toResponseDTO(updatedMovementType);
    }

    @Override
    public void deleteById(Integer id) {
        movementTypeService.deleteById(id);
    }
}
