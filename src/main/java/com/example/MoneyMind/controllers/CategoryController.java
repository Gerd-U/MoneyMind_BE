package com.example.MoneyMind.controllers;

import com.example.MoneyMind.dtos.CategoryRequestDTO;
import com.example.MoneyMind.dtos.CategoryResponseDTO;
import com.example.MoneyMind.facade.ICategoryFacade;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final ICategoryFacade categoryFacade;

    public CategoryController(ICategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> save(
            @Valid @RequestBody CategoryRequestDTO requestDTO) {

        CategoryResponseDTO responseDTO = categoryFacade.save(requestDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAll(
            @RequestParam(required = false) Integer idUsuario) {

        if (idUsuario != null) {
            return ResponseEntity.ok(categoryFacade.getAllByUser(idUsuario));
        }

        return ResponseEntity.ok(categoryFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getById(@PathVariable Integer id) {
        CategoryResponseDTO category = categoryFacade.getById(id);

        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody CategoryRequestDTO requestDTO) {

        CategoryResponseDTO updatedCategory = categoryFacade.update(id, requestDTO);

        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        categoryFacade.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
