package com.bootcamp.edadDeUnaPersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/edad")
public class EdadDeUnaPersonaController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public String getEdadPersona(@PathVariable int dia,
                                 @PathVariable int mes,
                                 @PathVariable int anio) {

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        long edad = ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);

        return "Usted tiene " + edad + " años.";
    }
}