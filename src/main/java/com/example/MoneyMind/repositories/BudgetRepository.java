package com.example.MoneyMind.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MoneyMind.entities.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> {

    List<Budget> findByIdUsuarioAndMonthAndYear(Integer idUsuario, Integer month, Integer year);
}
