package com.ajsw.ajswPayment.domain.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class Payment {
    private int id;
    private String description;
    private Double totalPrice;
}
