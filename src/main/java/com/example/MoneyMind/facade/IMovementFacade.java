package com.example.MoneyMind.facade;

import java.time.LocalDate;
import java.util.List;

import com.example.MoneyMind.dtos.MovementRequestDTO;
import com.example.MoneyMind.dtos.MovementResponseDTO;

public interface IMovementFacade {

    MovementResponseDTO save(MovementRequestDTO requestDTO);

    List<MovementResponseDTO> getByUsuarioAndDates(Integer idUsuario, LocalDate startDate, LocalDate endDate);

    MovementResponseDTO getById(Integer id);

    MovementResponseDTO update(Integer id, MovementRequestDTO requestDTO);

    void deleteById(Integer id);
}
