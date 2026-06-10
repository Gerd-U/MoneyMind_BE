package com.example.MoneyMind.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
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

import com.example.MoneyMind.dtos.MovementRequestDTO;
import com.example.MoneyMind.dtos.MovementResponseDTO;
import com.example.MoneyMind.facade.IMovementFacade;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movement")
public class MovementController {

    private final IMovementFacade movementFacade;

    public MovementController(IMovementFacade movementFacade) {
        this.movementFacade = movementFacade;
    }

    @PostMapping
    public ResponseEntity<MovementResponseDTO> save(@Valid @RequestBody MovementRequestDTO requestDTO) {
        return ResponseEntity.ok(movementFacade.save(requestDTO));
    }

    // GET /movement?idUsuario=1&startDate=2026-01-01&endDate=2026-06-30
    @GetMapping
    public ResponseEntity<List<MovementResponseDTO>> getByUsuarioAndDates(
            @RequestParam Integer idUsuario,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(movementFacade.getByUsuarioAndDates(idUsuario, startDate, endDate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementResponseDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(movementFacade.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementResponseDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody MovementRequestDTO requestDTO) {
        return ResponseEntity.ok(movementFacade.update(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        movementFacade.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
