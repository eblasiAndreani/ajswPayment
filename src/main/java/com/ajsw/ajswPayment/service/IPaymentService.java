package com.ajsw.ajswPayment.service;

import com.ajsw.ajswPayment.domain.entity.PaymentEntity;

import java.util.List;

public interface IPaymentService {
    public List<PaymentEntity> getAll();
    public PaymentEntity createPayment(double price, String description);
}
