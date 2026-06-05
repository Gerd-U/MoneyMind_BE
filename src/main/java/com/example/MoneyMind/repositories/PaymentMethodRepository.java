package com.example.MoneyMind.repositories;

import com.example.MoneyMind.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {

    default List<PaymentMethod> getAll() {
        return findAll();
    }
}
