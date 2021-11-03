package com.dia_nacimiento.nacimiento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FechaAEdad {


    @GetMapping("/{day}/{month}/{year}")
    public String convertir(@PathVariable("day") Integer day, @PathVariable("month") Integer month, @PathVariable("year") Integer year){
        return "El dia es: "+day+". El mes es:"+month;
    }
}
