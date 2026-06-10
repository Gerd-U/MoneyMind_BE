package com.example.MoneyMind.facade;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.MoneyMind.dtos.MovementRequestDTO;
import com.example.MoneyMind.dtos.MovementResponseDTO;
import com.example.MoneyMind.entities.Category;
import com.example.MoneyMind.entities.Movement;
import com.example.MoneyMind.entities.PaymentMethod;
import com.example.MoneyMind.exceptions.CategoryNotFoundException;
import com.example.MoneyMind.exceptions.PaymentMethodNotFoundException;
import com.example.MoneyMind.mappers.MovementMapper;
import com.example.MoneyMind.repositories.CategoryRepository;
import com.example.MoneyMind.repositories.PaymentMethodRepository;
import com.example.MoneyMind.services.IMovementService;

@Component
public class MovementFacade implements IMovementFacade {

    private final IMovementService movementService;
    private final MovementMapper movementMapper;
    private final CategoryRepository categoryRepository;
    private final PaymentMethodRepository paymentMethodRepository;

    public MovementFacade(IMovementService movementService,
                           MovementMapper movementMapper,
                           CategoryRepository categoryRepository,
                           PaymentMethodRepository paymentMethodRepository) {
        this.movementService = movementService;
        this.movementMapper = movementMapper;
        this.categoryRepository = categoryRepository;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public MovementResponseDTO save(MovementRequestDTO requestDTO) {
        Category category = categoryRepository.findById(requestDTO.getIdCategory())
                .orElseThrow(() -> new CategoryNotFoundException("Categoria no encontrada"));

        PaymentMethod paymentMethod = paymentMethodRepository.findById(requestDTO.getIdPaymentMethod())
                .orElseThrow(() -> new PaymentMethodNotFoundException("Método de pago no encontrado"));

        Movement movement = movementMapper.toEntity(requestDTO, category, paymentMethod);
        return movementMapper.toResponseDTO(movementService.save(movement));
    }

    @Override
    public List<MovementResponseDTO> getByUsuarioAndDates(Integer idUsuario, LocalDate startDate, LocalDate endDate) {
        return movementMapper.toResponseDTOList(
                movementService.getByUsuarioAndDates(idUsuario, startDate, endDate));
    }

    @Override
    public MovementResponseDTO getById(Integer id) {
        return movementMapper.toResponseDTO(movementService.getById(id));
    }

    @Override
    public MovementResponseDTO update(Integer id, MovementRequestDTO requestDTO) {
        Category category = categoryRepository.findById(requestDTO.getIdCategory())
                .orElseThrow(() -> new CategoryNotFoundException("Categoria no encontrada"));

        PaymentMethod paymentMethod = paymentMethodRepository.findById(requestDTO.getIdPaymentMethod())
                .orElseThrow(() -> new PaymentMethodNotFoundException("Método de pago no encontrado"));

        Movement movement = movementMapper.toEntity(requestDTO, category, paymentMethod);
        return movementMapper.toResponseDTO(movementService.update(id, movement));
    }

    @Override
    public void deleteById(Integer id) {
        movementService.deleteById(id);
    }
}
