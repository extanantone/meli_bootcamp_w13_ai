package com.example.C4SP2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LinkTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkTrackerApplication.class, args);
	}

}
/*
1- Post - Crear links de urls y un pass que devuelva un id
2- Get  - Redireccionar a un link valido, de ser invalido mostrar error
3- Get  - Devolver la cantidad de veces que se ha ingresado a ese link
4- Post - Invalidar un link por su id
5-
 */