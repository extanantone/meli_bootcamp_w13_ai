package com.edades.edad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {

    @GetMapping("/edades/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable() String dia, @PathVariable() String mes, @PathVariable() String anio) throws ParseException {

        LocalDate dateNow =  LocalDate.now();

        LocalDate birthDay = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes) , Integer.parseInt(dia));

        Period p = Period.between(birthDay, dateNow);

        return "Tenés " + String.valueOf(p.getYears()) + " años";

    }
}
