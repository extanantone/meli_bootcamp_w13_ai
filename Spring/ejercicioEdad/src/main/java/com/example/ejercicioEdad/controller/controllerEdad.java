package com.example.ejercicioEdad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
public class controllerEdad {
    @GetMapping(path="/{dia}/{mes}/{anio}")
    public int edad(@PathVariable("dia") int dia, @PathVariable("mes") int mes, @PathVariable("anio") int anio){
        String fecha= ""+dia+"/"+mes+"/"+anio;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fecha, formatter);
        Period edad = Period.between(fechaNacimiento, LocalDate.now());
        System.out.println(String.format("%d años, %d meses y %d días",
                edad.getYears(),
                edad.getMonths(),
                edad.getDays()));

        return edad.getYears();
    }
}
