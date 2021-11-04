package com.example.C2DTORESPONSEENTITY;

import com.example.C2DTORESPONSEENTITY.model.Deporte;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class C2DtoResponseEntityApplication {

	public static void main(String[] args) {

		SpringApplication.run(C2DtoResponseEntityApplication.class, args);
	}

}
