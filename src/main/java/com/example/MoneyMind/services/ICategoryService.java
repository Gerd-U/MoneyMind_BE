package com.example.MoneyMind.services;

import com.example.MoneyMind.entities.Category;

import java.util.List;

public interface ICategoryService {

    Category save(Category category);

    List<Category> getAll();

    List<Category> getAllByUser(Integer idUsuario);

    Category getById(Integer id);

    Category update(Integer id, Category updatedCategory);

    void deleteById(Integer id);
}
