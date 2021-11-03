package com.mercadolibre.ejercicio8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

@RestController
public class BirthDateController {
    @GetMapping("/{day}/{month}/{year}")
    public String normalizeNumber(@PathVariable("day") int day, @PathVariable("month") int month, @PathVariable("year") int year){
        try {
            LocalDate now= LocalDate.now();
            LocalDate birthDate= LocalDate.of(year, month, day);
            long years= YEARS.between(birthDate, now);

            return "La edad de la persona es: " + years + " años";
        } catch (Exception e) {
            return "La fecha es invalida";
        }
    }
}
