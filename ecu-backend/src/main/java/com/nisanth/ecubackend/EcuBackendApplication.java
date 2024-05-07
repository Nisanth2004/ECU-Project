package com.nisanth.ecubackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.nisanth.ecubackend")
public class EcuBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcuBackendApplication.class, args);
	}

}
