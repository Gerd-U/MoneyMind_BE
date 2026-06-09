package com.example.MoneyMind.mappers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.MoneyMind.dtos.BudgetRequestDTO;
import com.example.MoneyMind.dtos.BudgetResponseDTO;
import com.example.MoneyMind.entities.Budget;
import com.example.MoneyMind.entities.Category;

@Component
public class BudgetMapper {

    public Budget toEntity(BudgetRequestDTO dto, Category category) {
        if (dto == null) return null;

        return Budget.builder()
                .idUsuario(dto.getIdUsuario())
                .category(category)
                .limitAmount(dto.getLimitAmount())
                .month(dto.getMonth())
                .year(dto.getYear())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public BudgetResponseDTO toResponseDTO(Budget budget) {
        if (budget == null) return null;

        return BudgetResponseDTO.builder()
                .idBudget(budget.getIdBudget())
                .idUsuario(budget.getIdUsuario())
                .idCategory(budget.getCategory().getIdCategory())
                .categoryName(budget.getCategory().getCategoryName())
                .limitAmount(budget.getLimitAmount())
                .month(budget.getMonth())
                .year(budget.getYear())
                .createdAt(budget.getCreatedAt())
                .build();
    }

    public List<BudgetResponseDTO> toResponseDTOList(List<Budget> budgets) {
        if (budgets == null) return null;
        return budgets.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }
}
