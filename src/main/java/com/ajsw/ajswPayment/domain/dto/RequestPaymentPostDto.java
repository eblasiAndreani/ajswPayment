package com.ajsw.ajswPayment.domain.dto;

import lombok.Data;

@Data
public class RequestPaymentPostDto {
    private double totalPrice;
    private String description;
}
