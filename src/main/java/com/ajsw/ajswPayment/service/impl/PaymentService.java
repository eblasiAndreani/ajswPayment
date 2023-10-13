package com.ajsw.ajswPayment.service.impl;

import com.ajsw.ajswPayment.domain.entity.PaymentEntity;
import com.ajsw.ajswPayment.repository.IPaymentRepository;
import com.ajsw.ajswPayment.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    IPaymentRepository _paymentRepository;
    @Override
    public List<PaymentEntity> getAll(){

        return _paymentRepository.findAll();
    }
}
