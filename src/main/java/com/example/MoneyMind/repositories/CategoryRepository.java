package com.example.MoneyMind.repositories;

import com.example.MoneyMind.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    default List<Category> getAll() {
        return findAll();
    }

    List<Category> findByUser_Id(Integer idUsuario);

    boolean existsByUser_IdAndMovementType_IdMovementTypeAndCategoryNameIgnoreCase(
            Integer idUsuario,
            Integer idMovementType,
            String categoryName
    );
}
