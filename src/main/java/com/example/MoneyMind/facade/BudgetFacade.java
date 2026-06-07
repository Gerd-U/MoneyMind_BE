package com.example.MoneyMind.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.MoneyMind.dtos.BudgetRequestDTO;
import com.example.MoneyMind.dtos.BudgetResponseDTO;
import com.example.MoneyMind.entities.Budget;
import com.example.MoneyMind.entities.Category;
import com.example.MoneyMind.exceptions.CategoryNotFoundException;
import com.example.MoneyMind.mappers.BudgetMapper;
import com.example.MoneyMind.repositories.CategoryRepository;
import com.example.MoneyMind.services.IBudgetService;

@Component
public class BudgetFacade implements IBudgetFacade {

    private final IBudgetService budgetService;
    private final BudgetMapper budgetMapper;
    private final CategoryRepository categoryRepository;

    public BudgetFacade(IBudgetService budgetService,
                        BudgetMapper budgetMapper,
                        CategoryRepository categoryRepository) {
        this.budgetService = budgetService;
        this.budgetMapper = budgetMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public BudgetResponseDTO save(BudgetRequestDTO requestDTO) {
        Category category = categoryRepository.findById(requestDTO.getIdCategory())
                .orElseThrow(() -> new CategoryNotFoundException("Categoria no encontrada"));

        Budget budget = budgetMapper.toEntity(requestDTO, category);
        return budgetMapper.toResponseDTO(budgetService.save(budget));
    }

    @Override
    public List<BudgetResponseDTO> getByUsuarioAndMonthAndYear(Integer idUsuario, Integer month, Integer year) {
        return budgetMapper.toResponseDTOList(
                budgetService.getByUsuarioAndMonthAndYear(idUsuario, month, year));
    }

    @Override
    public BudgetResponseDTO getById(Integer id) {
        return budgetMapper.toResponseDTO(budgetService.getById(id));
    }

    @Override
    public BudgetResponseDTO update(Integer id, BudgetRequestDTO requestDTO) {
        Category category = categoryRepository.findById(requestDTO.getIdCategory())
                .orElseThrow(() -> new CategoryNotFoundException("Categoria no encontrada"));

        Budget budget = budgetMapper.toEntity(requestDTO, category);
        return budgetMapper.toResponseDTO(budgetService.update(id, budget));
    }

    @Override
    public void deleteById(Integer id) {
        budgetService.deleteById(id);
    }
}
