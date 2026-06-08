package com.example.MoneyMind.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MoneyMind.entities.Movement;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Integer> {

    List<Movement> findByIdUsuarioAndTransactionDateBetween(
            Integer idUsuario, LocalDate startDate, LocalDate endDate);
}
