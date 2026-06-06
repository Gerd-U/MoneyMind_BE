package com.example.MoneyMind.facade;

import com.example.MoneyMind.dtos.CategoryRequestDTO;
import com.example.MoneyMind.dtos.CategoryResponseDTO;
import com.example.MoneyMind.entities.Category;
import com.example.MoneyMind.entities.MovementType;
import com.example.MoneyMind.exceptions.MovementTypeNotFoundException;
import com.example.MoneyMind.mappers.CategoryMapper;
import com.example.MoneyMind.repositories.MovementTypeRepository;
import com.example.MoneyMind.services.ICategoryService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryFacade implements ICategoryFacade {

    private final ICategoryService categoryService;
    private final MovementTypeRepository movementTypeRepository;
    private final CategoryMapper categoryMapper;

    public CategoryFacade(ICategoryService categoryService,
                          MovementTypeRepository movementTypeRepository,
                          CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.movementTypeRepository = movementTypeRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryResponseDTO save(CategoryRequestDTO requestDTO) {
        MovementType movementType = movementTypeRepository.findById(requestDTO.getIdMovementType())
                .orElseThrow(() -> new MovementTypeNotFoundException("Tipo de movimiento no encontrado"));

        Category category = categoryMapper.toEntity(requestDTO, movementType);
        Category savedCategory = categoryService.save(category);

        return categoryMapper.toResponseDTO(savedCategory);
    }

    @Override
    public List<CategoryResponseDTO> getAll() {
        List<Category> categories = categoryService.getAll();

        return categoryMapper.toResponseDTOList(categories);
    }

    @Override
    public CategoryResponseDTO getById(Integer id) {
        Category category = categoryService.getById(id);

        return categoryMapper.toResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO update(Integer id, CategoryRequestDTO requestDTO) {
        MovementType movementType = movementTypeRepository.findById(requestDTO.getIdMovementType())
                .orElseThrow(() -> new MovementTypeNotFoundException("Tipo de movimiento no encontrado"));

        Category category = categoryMapper.toEntity(requestDTO, movementType);
        Category updatedCategory = categoryService.update(id, category);

        return categoryMapper.toResponseDTO(updatedCategory);
    }

    @Override
    public void deleteById(Integer id) {
        categoryService.deleteById(id);
    }
}
