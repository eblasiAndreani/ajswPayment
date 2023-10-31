package com.ajsw.ajswPayment.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponsePaymentPostDto {
    private Payment body;
    private Errors errors;
}
