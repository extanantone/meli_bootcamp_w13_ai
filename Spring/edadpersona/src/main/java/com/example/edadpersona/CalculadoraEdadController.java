package com.example.edadpersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
public class CalculadoraEdadController {

    @GetMapping("/{dia}/{mes}/{año}")
    public String getEdad(@PathVariable int año, @PathVariable int mes, @PathVariable int dia) {
        LocalDate birthdate = LocalDate.of(año, mes, dia);
        LocalDate now = LocalDate.now();
        Long years = ChronoUnit.YEARS.between(birthdate, now);
        return years.toString();
    }
}
