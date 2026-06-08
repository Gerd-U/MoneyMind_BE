package com.example.MoneyMind.services;

import java.time.LocalDate;
import java.util.List;

import com.example.MoneyMind.entities.Movement;

public interface IMovementService {

    Movement save(Movement transaction);

    List<Movement> getByUsuarioAndDates(Integer idUsuario, LocalDate startDate, LocalDate endDate);

    Movement getById(Integer id);

    Movement update(Integer id, Movement updatedTransaction);

    void deleteById(Integer id);
}
