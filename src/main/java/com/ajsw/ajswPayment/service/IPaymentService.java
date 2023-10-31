package com.ajsw.ajswPayment.service;

import com.ajsw.ajswPayment.domain.dto.Payment;
import com.ajsw.ajswPayment.domain.entity.PaymentEntity;

import java.util.List;

public interface IPaymentService {
    public List<Payment> getAll();
    public Payment createPayment(double price, String description);
}
