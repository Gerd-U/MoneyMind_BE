package com.example.MoneyMind.services;

import java.time.LocalDate;
import java.util.List;

import com.example.MoneyMind.entities.Movement;

public interface IMovementService {

    Movement save(Movement movement);

    List<Movement> getByUsuarioAndDates(Integer idUsuario, LocalDate startDate, LocalDate endDate);

    Movement getById(Integer id);

    Movement update(Integer id, Movement updatedMovement);

    void deleteById(Integer id);
}
