package com.example.EdadPersona.controller;

import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {

    @GetMapping("/edad/{day}/{month}/{year}")
    public String calcularEdad(@PathVariable int day,
                               @PathVariable int month,
                               @PathVariable int year)
    {
        LocalDate yearPersona = LocalDate.of(year,month,day);
        LocalDate hoy = LocalDate.now();

        Period period = Period.between(yearPersona, hoy);

        return "Los años son "+period.getYears();
    }

}
