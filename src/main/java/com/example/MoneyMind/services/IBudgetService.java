package com.example.MoneyMind.services;

import java.util.List;

import com.example.MoneyMind.entities.Budget;

public interface IBudgetService {

    Budget save(Budget budget);

    List<Budget> getByUsuarioAndMonthAndYear(Integer idUsuario, Integer month, Integer year);

    Budget getById(Integer id);

    Budget update(Integer id, Budget updatedBudget);

    void deleteById(Integer id);
}
