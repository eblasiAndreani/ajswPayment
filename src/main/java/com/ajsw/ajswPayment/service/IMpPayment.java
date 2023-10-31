package com.ajsw.ajswPayment.service;

import com.ajsw.ajswPayment.domain.dto.Sandbox;


public interface IMpPayment {
    public Sandbox GetSandbox(double importe, String descripcion);
}
