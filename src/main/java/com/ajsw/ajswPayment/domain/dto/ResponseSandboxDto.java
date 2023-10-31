package com.ajsw.ajswPayment.domain.dto;

import lombok.Data;

@Data
public class ResponseSandboxDto {
    private Sandbox body;
    private Errors errors;
}
