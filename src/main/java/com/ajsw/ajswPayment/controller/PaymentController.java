package com.ajsw.ajswPayment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllPayment(){
        return null;
    }
}
