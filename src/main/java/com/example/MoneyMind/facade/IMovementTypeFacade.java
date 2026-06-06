package com.example.MoneyMind.facade;
import java.util.List;

import com.example.MoneyMind.dtos.MovementTypeRequestDTO;
import com.example.MoneyMind.dtos.MovementTypeResponseDTO;

public interface IMovementTypeFacade {

    MovementTypeResponseDTO save(MovementTypeRequestDTO requestDTO);

    List<MovementTypeResponseDTO> getAll();

    MovementTypeResponseDTO getById(Integer id);

    MovementTypeResponseDTO update(Integer id, MovementTypeRequestDTO requestDTO);

    void deleteById(Integer id);
}
