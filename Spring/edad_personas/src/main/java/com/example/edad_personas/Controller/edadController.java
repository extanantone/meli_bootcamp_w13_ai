package com.example.edad_personas.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class edadController {
    @GetMapping("/calcularEdad")
    public Integer calcularEdad (@RequestParam String date){
        try {
            LocalDate now = LocalDate.now();
            LocalDate test = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Period edad = Period.between(test,now);
            return Math.max(edad.getYears(), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }
}
