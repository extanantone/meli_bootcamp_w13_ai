package com.C2P1.EdadPersona.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@RestController
public class CalcularEdad {

    @GetMapping(path = "edad/{day}/{month}/{year}")
    public String CalcularEdad (@PathVariable int day, @PathVariable int month, @PathVariable int year){

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(year, month, day);

        Period fechaResultado = Period.between(fechaNacimiento, fechaActual);

        return String.format("La edad de la persona es de %d años", fechaResultado.getYears());
    }

}
