package com.example.MoneyMind.mappers;

import com.example.MoneyMind.dtos.CategoryRequestDTO;
import com.example.MoneyMind.dtos.CategoryResponseDTO;
import com.example.MoneyMind.entities.Category;
import com.example.MoneyMind.entities.MovementType;
import com.example.MoneyMind.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDTO dto, MovementType movementType, User user) {
        if (dto == null) {
            return null;
        }

        return Category.builder()
                .user(user)
                .movementType(movementType)
                .categoryName(dto.getCategoryName())
                .description(dto.getDescription())
                .active(dto.getActive())
                .build();
    }

    public CategoryResponseDTO toResponseDTO(Category category) {
        if (category == null) {
            return null;
        }

        return CategoryResponseDTO.builder()
                .idCategory(category.getIdCategory())
                .idUsuario(category.getUser().getId())
                .idMovementType(category.getMovementType().getIdMovementType())
                .movementTypeName(category.getMovementType().getTypeName())
                .categoryName(category.getCategoryName())
                .description(category.getDescription())
                .active(category.getActive())
                .build();
    }

    public List<CategoryResponseDTO> toResponseDTOList(List<Category> categories) {
        if (categories == null) {
            return null;
        }

        return categories.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
