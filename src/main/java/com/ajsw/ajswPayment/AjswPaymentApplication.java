package com.ajsw.ajswPayment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
public class AjswPaymentApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(AjswPaymentApplication.class);

	public static void main(String[] args) {
		LOGGER.info("the application is run.....");
		SpringApplication.run(AjswPaymentApplication.class, args);
		LOGGER.info("the application is now running.....");
	}

}
