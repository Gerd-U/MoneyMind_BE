package com.example.MoneyMind.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.MoneyMind.entities.Budget;
import com.example.MoneyMind.exceptions.BudgetNotFoundException;
import com.example.MoneyMind.repositories.BudgetRepository;

@Service
public class BudgetService implements IBudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @Override
    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public List<Budget> getByUsuarioAndMonthAndYear(Integer idUsuario, Integer month, Integer year) {
        return budgetRepository.findByIdUsuarioAndMonthAndYear(idUsuario, month, year);
    }

    @Override
    public Budget getById(Integer id) {
        return budgetRepository.findById(id)
                .orElseThrow(() -> new BudgetNotFoundException("Presupuesto no encontrado"));
    }

    @Override
    public Budget update(Integer id, Budget updatedBudget) {
        Budget budget = getById(id);
        budget.setCategory(updatedBudget.getCategory());
        budget.setLimitAmount(updatedBudget.getLimitAmount());
        budget.setMonth(updatedBudget.getMonth());
        budget.setYear(updatedBudget.getYear());
        return budgetRepository.save(budget);
    }

    @Override
    public void deleteById(Integer id) {
        if (!budgetRepository.existsById(id)) {
            throw new BudgetNotFoundException("Presupuesto no encontrado");
        }
        budgetRepository.deleteById(id);
    }
}
