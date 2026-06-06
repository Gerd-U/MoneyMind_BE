package com.example.MoneyMind.facade;

import com.example.MoneyMind.dtos.CategoryRequestDTO;
import com.example.MoneyMind.dtos.CategoryResponseDTO;

import java.util.List;

public interface ICategoryFacade {

    CategoryResponseDTO save(CategoryRequestDTO requestDTO);

    List<CategoryResponseDTO> getAll();

    CategoryResponseDTO getById(Integer id);

    CategoryResponseDTO update(Integer id, CategoryRequestDTO requestDTO);

    void deleteById(Integer id);
}