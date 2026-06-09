package com.example.MoneyMind.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoneyMind.dtos.BudgetRequestDTO;
import com.example.MoneyMind.dtos.BudgetResponseDTO;
import com.example.MoneyMind.facade.IBudgetFacade;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private final IBudgetFacade budgetFacade;

    public BudgetController(IBudgetFacade budgetFacade) {
        this.budgetFacade = budgetFacade;
    }

    @PostMapping
    public ResponseEntity<BudgetResponseDTO> save(@Valid @RequestBody BudgetRequestDTO requestDTO) {
        return ResponseEntity.ok(budgetFacade.save(requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<BudgetResponseDTO>> getByUsuarioAndMonthAndYear(
            @RequestParam Integer idUsuario,
            @RequestParam Integer month,
            @RequestParam Integer year) {
        return ResponseEntity.ok(budgetFacade.getByUsuarioAndMonthAndYear(idUsuario, month, year));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetResponseDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(budgetFacade.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BudgetResponseDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody BudgetRequestDTO requestDTO) {
        return ResponseEntity.ok(budgetFacade.update(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        budgetFacade.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
