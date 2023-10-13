package com.ajsw.ajswPayment.service;

import org.springframework.context.annotation.Bean;


public interface IMpPayment {
    public String GetSandbox(double importe, String descripcion);
}
