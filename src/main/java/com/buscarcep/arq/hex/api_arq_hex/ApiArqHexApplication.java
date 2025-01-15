package com.buscarcep.arq.hex.api_arq_hex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.buscarcep.arq.hex.api_arq_hex.*")
public class ApiArqHexApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiArqHexApplication.class, args);
	}

}
