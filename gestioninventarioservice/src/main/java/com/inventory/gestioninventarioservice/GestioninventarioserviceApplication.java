package com.inventory.gestioninventarioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GestioninventarioserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioninventarioserviceApplication.class, args);
	}

}
