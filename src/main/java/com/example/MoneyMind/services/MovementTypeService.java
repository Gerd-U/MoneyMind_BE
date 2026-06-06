package com.example.MoneyMind.services;

import java.util.List;

import com.example.MoneyMind.entities.MovementType;
import com.example.MoneyMind.exceptions.MovementTypeNotFoundException;
import com.example.MoneyMind.repositories.MovementTypeRepository;

public class MovementTypeService implements IMovementTypeService {

    private final MovementTypeRepository movementTypeRepository;

    public MovementTypeService(MovementTypeRepository movementTypeRepository) {
        this.movementTypeRepository = movementTypeRepository;
    }

    @Override
    public MovementType save(MovementType movementType) {
        return movementTypeRepository.save(movementType);
    }

    @Override
    public List<MovementType> getAll() {
        return movementTypeRepository.getAll();
    }

    @Override
    public MovementType getById(Integer id) {
        return movementTypeRepository.findById(id)
                .orElseThrow(() -> new MovementTypeNotFoundException("Tipo de movimiento no encontrado"));
    }

    @Override
    public MovementType update(Integer id, MovementType updatedMovementType) {
        MovementType movementType = getById(id);

        movementType.setTypeName(updatedMovementType.getTypeName());

        return movementTypeRepository.save(movementType);
    }

    @Override
    public void deleteById(Integer id) {
        if (!movementTypeRepository.existsById(id)) {
            throw new MovementTypeNotFoundException("Tipo de movimiento no encontrado");
        }

        movementTypeRepository.deleteById(id);
    }
    
}
