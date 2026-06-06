package com.example.MoneyMind.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MoneyMind.entities.MovementType;

@Repository
public interface MovementTypeRepository extends JpaRepository<MovementType, Integer> {

    default List<MovementType> getAll() {
        return findAll();
    }
}
