package com.MELI.EdadDeLaPersona.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class EdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable("dia") int dia,
                       @PathVariable("mes") int mes,
                       @PathVariable("anio") int anio){

        LocalDate fecha = LocalDate.of(anio, mes, dia);
        return LocalDate.now().compareTo(fecha);

        //No contempla si cumpliste o no años
        //return LocalDate.now().getYear() - anio;
    }
}
