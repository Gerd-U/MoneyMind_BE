package com.example.MoneyMind.facade;

import java.util.List;

import com.example.MoneyMind.dtos.BudgetRequestDTO;
import com.example.MoneyMind.dtos.BudgetResponseDTO;

public interface IBudgetFacade {

    BudgetResponseDTO save(BudgetRequestDTO requestDTO);

    List<BudgetResponseDTO> getByUsuarioAndMonthAndYear(Integer idUsuario, Integer month, Integer year);

    BudgetResponseDTO getById(Integer id);

    BudgetResponseDTO update(Integer id, BudgetRequestDTO requestDTO);

    void deleteById(Integer id);
}
