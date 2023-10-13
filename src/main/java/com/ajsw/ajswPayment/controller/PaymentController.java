package com.ajsw.ajswPayment.controller;

import com.ajsw.ajswPayment.domain.dto.ResponseSansboxDTO;
import com.ajsw.ajswPayment.domain.entity.PaymentEntity;
import com.ajsw.ajswPayment.service.IMpPayment;
import com.ajsw.ajswPayment.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {
    @Autowired
    IMpPayment _mpPayment;
    @Autowired
    IPaymentService _paymentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<PaymentEntity>> getAllPayment(){
        try{
            List<PaymentEntity> a = _paymentService.getAll();
            return ResponseEntity.ok(a);
        }catch (Exception ex) {
            return null;
        }

    }

    @GetMapping("/payment/getSandbox")
    public ResponseEntity<ResponseSansboxDTO> getPaymentSandbox(double price, String description){
        String sandbox = _mpPayment.GetSandbox(price, description);

        ResponseSansboxDTO sandboxDTO = new ResponseSansboxDTO();
        sandboxDTO.SandboxInit = sandbox;

        return ResponseEntity.ok(sandboxDTO);
    }

    @PostMapping("/postPayment")
    public ResponseEntity<String> postPayment(){
        //_mpPayment
        return null;
    }
}
