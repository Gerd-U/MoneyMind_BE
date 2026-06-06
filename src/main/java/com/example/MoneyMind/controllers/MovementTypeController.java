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
import org.springframework.web.bind.annotation.RestController;

import com.example.MoneyMind.dtos.MovementTypeRequestDTO;
import com.example.MoneyMind.dtos.MovementTypeResponseDTO;
import com.example.MoneyMind.facade.IMovementTypeFacade;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movement-types")
public class MovementTypeController {

    private final IMovementTypeFacade movementTypeFacade;

    public MovementTypeController(IMovementTypeFacade movementTypeFacade) {
        this.movementTypeFacade = movementTypeFacade;
    }

    @PostMapping
    public ResponseEntity<MovementTypeResponseDTO> save(
            @Valid @RequestBody MovementTypeRequestDTO requestDTO) {

        MovementTypeResponseDTO responseDTO = movementTypeFacade.save(requestDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<MovementTypeResponseDTO>> getAll() {
        List<MovementTypeResponseDTO> movementTypes = movementTypeFacade.getAll();

        return ResponseEntity.ok(movementTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementTypeResponseDTO> getById(@PathVariable Integer id) {
        MovementTypeResponseDTO movementType = movementTypeFacade.getById(id);

        return ResponseEntity.ok(movementType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementTypeResponseDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody MovementTypeRequestDTO requestDTO) {

        MovementTypeResponseDTO updatedMovementType = movementTypeFacade.update(id, requestDTO);

        return ResponseEntity.ok(updatedMovementType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        movementTypeFacade.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
