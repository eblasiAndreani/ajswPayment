package com.ajsw.ajswPayment.service.impl;
import com.ajsw.ajswPayment.domain.dto.Sandbox;
import com.ajsw.ajswPayment.service.IMpPayment;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.preference.Preference;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MpPayment implements IMpPayment {
    //@Value("${PROD_ACCESS_TOKEN}")
    public String token = "TEST-3647306127729066-101200-fd1f58df78adb7e176468375710187f7-1508099707";

    public Sandbox GetSandbox(double price, String description){
        Preference preference = CreatePayment(price, description);

        Sandbox sandboxDto = new Sandbox();
        sandboxDto.setSandboxInit(preference.getSandboxInitPoint());

        return sandboxDto;
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

            //Se debe configurar las url a consumir cuando sucede cada accion.//
            PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                    .success("http://localhost:3000/reserva")
                    .pending("http://localhost:3000/login")
                    .failure("http://localhost:3000/buscar")
                    .build();

            PreferenceRequest request = PreferenceRequest
                    .builder()
                    .items(items)
                    .backUrls(backUrls)
                    .autoReturn("approved")
                    .build();
            PreferenceClient client = new PreferenceClient();

            preference = client.create(request);

        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return preference;
    }
}
