package com.ajsw.ajswPayment.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseGetAllDto {
    private List<Payment> body;
    private Errors errors;
}
