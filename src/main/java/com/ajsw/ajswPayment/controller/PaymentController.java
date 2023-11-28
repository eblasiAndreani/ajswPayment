package com.ajsw.ajswPayment.controller;

import com.ajsw.ajswPayment.domain.dto.*;
import com.ajsw.ajswPayment.service.IMpPayment;
import com.ajsw.ajswPayment.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/payment")
@CrossOrigin(originPatterns = "http://localhost:3000")
public class PaymentController {
    @Autowired
    IMpPayment _mpPayment;
    @Autowired
    IPaymentService _paymentService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseGetAllDto> getAllPayment(){
        ResponseGetAllDto responseGetAllDto = new ResponseGetAllDto();
        try{
            List<Payment> payments = _paymentService.getAll();

            responseGetAllDto.setBody(payments);

            return ResponseEntity.ok(responseGetAllDto);
        }catch (Exception ex) {
            responseGetAllDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseGetAllDto);
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
    public ResponseEntity<ResponseSandboxDto> getPaymentSandbox(double price, String description){
        ResponseSandboxDto sandboxDTO = new ResponseSandboxDto();
        try{
            Sandbox sandbox = _mpPayment.GetSandbox(price, description);

            sandboxDTO.setBody(sandbox);

            return ResponseEntity.ok(sandboxDTO);
        }catch (Exception ex){
            sandboxDTO.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(sandboxDTO);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponsePaymentPostDto> postPayment(@RequestBody RequestPaymentPostDto dates){
        ResponsePaymentPostDto responsePaymentPostDto = new ResponsePaymentPostDto();
        try{
            Payment payment = _paymentService.createPayment(dates.getTotalPrice(), dates.getDescription());

            responsePaymentPostDto.setBody(payment);

            return ResponseEntity.status(HttpStatus.CREATED).body(responsePaymentPostDto);
        }catch (Exception ex){
            responsePaymentPostDto.setErrors(new Errors(500, ex.getMessage(), Arrays.toString(ex.getStackTrace())));
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responsePaymentPostDto);
        }
    }
}