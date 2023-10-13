package com.ajsw.ajswPayment.service.impl;
import com.ajsw.ajswPayment.service.IMpPayment;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.preference.Preference;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MpPayment implements IMpPayment {
    //@Value("${PROD_ACCESS_TOKEN}")
    public String token = "TEST-3647306127729066-101200-fd1f58df78adb7e176468375710187f7-1508099707";

    public String GetSandbox(double price, String description){
        Preference preference = CreatePayment(price, description);

        return preference.getSandboxInitPoint();
    }

    private Preference CreatePayment(double price, String description){
        Preference preference = null;
        try {
            MercadoPagoConfig.setAccessToken(token);

            PreferenceItemRequest itemRequest =
                    PreferenceItemRequest.builder()
                            .id("1234")
                            .title("Pedido")
                            .description(description)
                            //.pictureUrl("http://picture.com/PS5")
                            .categoryId("bar")
                            .quantity(1)
                            .currencyId("ARS")
                            .unitPrice(new BigDecimal(price))
                            .build();
            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);

            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items).build();
            PreferenceClient client = new PreferenceClient();

            preference = client.create(preferenceRequest);

        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return preference;
    }
}
