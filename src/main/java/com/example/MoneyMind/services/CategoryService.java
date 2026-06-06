package com.example.MoneyMind.services;

import com.example.MoneyMind.entities.Category;
import com.example.MoneyMind.exceptions.CategoryNotFoundException;
import com.example.MoneyMind.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Categoría no encontrada"));
    }

    @Override
    public Category update(Integer id, Category updatedCategory) {
        Category category = getById(id);

        category.setMovementType(updatedCategory.getMovementType());
        category.setCategoryName(updatedCategory.getCategoryName());
        category.setDescription(updatedCategory.getDescription());
        category.setActive(updatedCategory.getActive());

        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException("Categoría no encontrada");
        }

        categoryRepository.deleteById(id);
    }
}