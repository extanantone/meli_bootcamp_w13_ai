package com.example.spring.Deporte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeporteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeporteApplication.class, args);
		FakeBD.inicializarDeportesBD();

	}


}
