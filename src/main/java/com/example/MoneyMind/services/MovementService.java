package com.example.MoneyMind.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.MoneyMind.entities.Movement;
import com.example.MoneyMind.exceptions.MovementNotFoundException;
import com.example.MoneyMind.repositories.MovementRepository;

@Service
public class MovementService implements IMovementService {

    private final MovementRepository movementRepository;

    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public Movement save(Movement transaction) {
        return movementRepository.save(transaction);
    }

    @Override
    public List<Movement> getByUsuarioAndDates(Integer idUsuario, LocalDate startDate, LocalDate endDate) {
        return movementRepository.findByIdUsuarioAndTransactionDateBetween(
                idUsuario, startDate, endDate);
    }

    @Override
    public Movement getById(Integer id) {
        return movementRepository.findById(id)
                .orElseThrow(() -> new MovementNotFoundException("Tipo de movimiento no encontrado"));
    }

    @Override
    public Movement update(Integer id, Movement updatedTransaction) {
        Movement transaction = getById(id);
        transaction.setAmount(updatedTransaction.getAmount());
        transaction.setDescription(updatedTransaction.getDescription());
        transaction.setTransactionDate(updatedTransaction.getTransactionDate());
        transaction.setCategory(updatedTransaction.getCategory());
        transaction.setPaymentMethod(updatedTransaction.getPaymentMethod());
        return movementRepository.save(transaction);
    }

    @Override
    public void deleteById(Integer id) {
        if (!movementRepository.existsById(id)) {
            throw new MovementNotFoundException("Tipo de movimiento no encontrado");
        }
        movementRepository.deleteById(id);
    }
}
