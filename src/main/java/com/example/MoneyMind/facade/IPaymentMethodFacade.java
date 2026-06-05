package com.example.MoneyMind.facade;

import com.example.MoneyMind.dtos.PaymentMethodRequestDTO;
import com.example.MoneyMind.dtos.PaymentMethodResponseDTO;

import java.util.List;

public interface IPaymentMethodFacade {

    PaymentMethodResponseDTO save(PaymentMethodRequestDTO requestDTO);

    List<PaymentMethodResponseDTO> getAll();

    PaymentMethodResponseDTO getById(Integer id);

    PaymentMethodResponseDTO update(Integer id, PaymentMethodRequestDTO requestDTO);

    void deleteById(Integer id);
}