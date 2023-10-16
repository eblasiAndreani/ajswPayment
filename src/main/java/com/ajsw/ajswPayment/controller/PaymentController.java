package com.ajsw.ajswPayment.controller;

import com.ajsw.ajswPayment.domain.dto.RequestPaymentPostDto;
import com.ajsw.ajswPayment.domain.dto.ResponseSansboxDTO;
import com.ajsw.ajswPayment.domain.entity.PaymentEntity;
import com.ajsw.ajswPayment.service.IMpPayment;
import com.ajsw.ajswPayment.service.IPaymentService;
import io.swagger.v3.oas.models.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
    @GetMapping("/pruebaMP")
    public ResponseEntity<String> getAllPayment(String payment_id, String status, String external_reference, String merchant_order_id){
        try{
            System.out.println("payment_id"+ payment_id + "status" +status + "external_reference: " +external_reference + "merchant_order_id: " + merchant_order_id);
            return ResponseEntity.ok("OK");
        }catch (Exception ex) {
            return null;
        }
    }


    @GetMapping("/getSandbox")
    public ResponseEntity<ResponseSansboxDTO> getPaymentSandbox(double price, String description){
        String sandbox = _mpPayment.GetSandbox(price, description);

        ResponseSansboxDTO sandboxDTO = new ResponseSansboxDTO();
        sandboxDTO.SandboxInit = sandbox;

        return ResponseEntity.ok(sandboxDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<PaymentEntity> postPayment(@RequestBody RequestPaymentPostDto dates){

        PaymentEntity payment = _paymentService.createPayment(dates.totalPrice, dates.description);
        if ( payment == null){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}