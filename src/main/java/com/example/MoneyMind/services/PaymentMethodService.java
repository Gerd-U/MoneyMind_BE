package com.example.MoneyMind.services;

import com.example.MoneyMind.entities.PaymentMethod;
import com.example.MoneyMind.exceptions.PaymentMethodNotFoundException;
import com.example.MoneyMind.repositories.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService implements IPaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public List<PaymentMethod> getAll() {
        return paymentMethodRepository.getAll();
    }

    @Override
    public PaymentMethod getById(Integer id) {
    return paymentMethodRepository.findById(id)
            .orElseThrow(() -> new PaymentMethodNotFoundException("Método de pago no encontrado"));
    }

    @Override
    public PaymentMethod update(Integer id, PaymentMethod updatedPaymentMethod) {
        PaymentMethod paymentMethod = getById(id);

        paymentMethod.setMethodName(updatedPaymentMethod.getMethodName());

        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void deleteById(Integer id) {
    if (!paymentMethodRepository.existsById(id)) {
        throw new PaymentMethodNotFoundException("Método de pago no encontrado");
    }

    paymentMethodRepository.deleteById(id);
    }
}