package com.example.MoneyMind.facade;

import com.example.MoneyMind.dtos.PaymentMethodRequestDTO;
import com.example.MoneyMind.dtos.PaymentMethodResponseDTO;
import com.example.MoneyMind.entities.PaymentMethod;
import com.example.MoneyMind.mappers.PaymentMethodMapper;
import com.example.MoneyMind.services.IPaymentMethodService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentMethodFacade implements IPaymentMethodFacade {

    private final IPaymentMethodService paymentMethodService;
    private final PaymentMethodMapper paymentMethodMapper;

    public PaymentMethodFacade(IPaymentMethodService paymentMethodService,
                               PaymentMethodMapper paymentMethodMapper) {
        this.paymentMethodService = paymentMethodService;
        this.paymentMethodMapper = paymentMethodMapper;
    }

    @Override
    public PaymentMethodResponseDTO save(PaymentMethodRequestDTO requestDTO) {
        PaymentMethod paymentMethod = paymentMethodMapper.toEntity(requestDTO);
        PaymentMethod savedPaymentMethod = paymentMethodService.save(paymentMethod);

        return paymentMethodMapper.toResponseDTO(savedPaymentMethod);
    }

    @Override
    public List<PaymentMethodResponseDTO> getAll() {
        List<PaymentMethod> paymentMethods = paymentMethodService.getAll();

        return paymentMethodMapper.toResponseDTOList(paymentMethods);
    }

    @Override
    public PaymentMethodResponseDTO getById(Integer id) {
        PaymentMethod paymentMethod = paymentMethodService.getById(id);

        return paymentMethodMapper.toResponseDTO(paymentMethod);
    }

    @Override
    public PaymentMethodResponseDTO update(Integer id, PaymentMethodRequestDTO requestDTO) {
        PaymentMethod paymentMethod = paymentMethodMapper.toEntity(requestDTO);
        PaymentMethod updatedPaymentMethod = paymentMethodService.update(id, paymentMethod);

        return paymentMethodMapper.toResponseDTO(updatedPaymentMethod);
    }

    @Override
    public void deleteById(Integer id) {
        paymentMethodService.deleteById(id);
    }
}