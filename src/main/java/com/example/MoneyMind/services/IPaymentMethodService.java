package com.example.MoneyMind.services;

import com.example.MoneyMind.entities.PaymentMethod;

import java.util.List;

public interface IPaymentMethodService {

    PaymentMethod save(PaymentMethod paymentMethod);

    List<PaymentMethod> getAll();

    PaymentMethod getById(Integer id);

    PaymentMethod update(Integer id, PaymentMethod updatedPaymentMethod);

    void deleteById(Integer id);
}