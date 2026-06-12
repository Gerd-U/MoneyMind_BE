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
    public Movement save(Movement movement) {
        return movementRepository.save(movement);
    }

    @Override
    public List<Movement> getByUsuarioAndDates(Integer idUsuario, LocalDate startDate, LocalDate endDate) {
        return movementRepository.findByIdUsuarioAndMovementDateBetween(
                idUsuario, startDate, endDate);
    }

    @Override
    public Movement getById(Integer id) {
        return movementRepository.findById(id)
                .orElseThrow(() -> new MovementNotFoundException("Movimiento no encontrado"));
    }

    @Override
    public Movement update(Integer id, Movement updatedMovement) {
        Movement movement = getById(id);
        movement.setAmount(updatedMovement.getAmount());
        movement.setDescription(updatedMovement.getDescription());
        movement.setMovementDate(updatedMovement.getMovementDate());
        movement.setCategory(updatedMovement.getCategory());
        movement.setPaymentMethod(updatedMovement.getPaymentMethod());
        return movementRepository.save(movement);
    }

    @Override
    public void deleteById(Integer id) {
        if (!movementRepository.existsById(id)) {
            throw new MovementNotFoundException("Movimiento no encontrado");
        }
        movementRepository.deleteById(id);
    }
}
