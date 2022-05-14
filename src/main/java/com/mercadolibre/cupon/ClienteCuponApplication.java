package com.mercadolibre.cupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
public class ClienteCuponApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteCuponApplication.class, args);
	}
	
	@Bean
	 public RestTemplate createTemplate() {
		RestTemplate plantilla = new RestTemplate();
		
		return plantilla;
	}

}
