package com.ajsw.ajswPayment.service.impl;

import com.ajsw.ajswPayment.domain.dto.Payment;
import com.ajsw.ajswPayment.domain.entity.PaymentEntity;
import com.ajsw.ajswPayment.repository.IPaymentRepository;
import com.ajsw.ajswPayment.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    IPaymentRepository _paymentRepository;
    @Override
    public List<Payment> getAll(){

        List<PaymentEntity> paymentEntities = _paymentRepository.findAll();

        List<Payment> paymentList = new ArrayList<>();

        for (PaymentEntity paymentEntity: paymentEntities) {
            Payment payment = new Payment();
            payment.setId(paymentEntity.getId());
            payment.setDescription(paymentEntity.getDescription());
            payment.setTotalPrice(paymentEntity.getTotalPrice());

            paymentList.add(payment);
        }

        return paymentList;
    }
    public Payment createPayment(double price, String description){

        try{
            PaymentEntity paymentDb = new PaymentEntity();
            Payment payment = new Payment();

            paymentDb.setTotalPrice(price);
            paymentDb.setDescription(description);

            payment.setId(_paymentRepository.save(paymentDb).getId());
            payment.setTotalPrice(paymentDb.getTotalPrice());
            payment.setDescription(paymentDb.getDescription());

            return payment;
        }catch (Exception ex){
            System.out.println("PaymentService: createPayment => " +ex.getMessage());
            throw ex;
        }

    }
}
