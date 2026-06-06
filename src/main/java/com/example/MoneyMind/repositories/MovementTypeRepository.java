package com.example.MoneyMind.repositories;

import com.example.MoneyMind.entities.MovementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementTypeRepository extends JpaRepository<MovementType, Integer> {

    default List<MovementType> getAll() {
        return findAll();
    }
}
