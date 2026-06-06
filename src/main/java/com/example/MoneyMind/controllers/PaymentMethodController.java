package com.example.MoneyMind.controllers;

import com.example.MoneyMind.dtos.PaymentMethodRequestDTO;
import com.example.MoneyMind.dtos.PaymentMethodResponseDTO;
import com.example.MoneyMind.facade.IPaymentMethodFacade;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodController {

    private final IPaymentMethodFacade paymentMethodFacade;

    public PaymentMethodController(IPaymentMethodFacade paymentMethodFacade) {
        this.paymentMethodFacade = paymentMethodFacade;
    }

    @PostMapping
    public ResponseEntity<PaymentMethodResponseDTO> save(
            @Valid @RequestBody PaymentMethodRequestDTO requestDTO) {

        PaymentMethodResponseDTO responseDTO = paymentMethodFacade.save(requestDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PaymentMethodResponseDTO>> getAll() {
        List<PaymentMethodResponseDTO> paymentMethods = paymentMethodFacade.getAll();

        return ResponseEntity.ok(paymentMethods);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethodResponseDTO> getById(@PathVariable Integer id) {
        PaymentMethodResponseDTO paymentMethod = paymentMethodFacade.getById(id);

        return ResponseEntity.ok(paymentMethod);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethodResponseDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody PaymentMethodRequestDTO requestDTO) {

        PaymentMethodResponseDTO updatedPaymentMethod = paymentMethodFacade.update(id, requestDTO);

        return ResponseEntity.ok(updatedPaymentMethod);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        paymentMethodFacade.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}