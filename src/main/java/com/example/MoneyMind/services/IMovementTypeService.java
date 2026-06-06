package com.example.MoneyMind.services;

import java.util.List;

import com.example.MoneyMind.entities.MovementType;

public interface IMovementTypeService {
    MovementType save(MovementType movementType);

    List<MovementType> getAll();

    MovementType getById(Integer id);

    MovementType update(Integer id, MovementType updatedMovementType);

    void deleteById(Integer id);
}
