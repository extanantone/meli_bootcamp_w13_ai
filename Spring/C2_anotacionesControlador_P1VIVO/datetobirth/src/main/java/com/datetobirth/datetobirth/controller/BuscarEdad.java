package com.datetobirth.datetobirth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import static java.util.Calendar.*;


@RestController
public class BuscarEdad {

    @GetMapping
    public String mostrarMensaje(){
        return "hola";
    }

    @GetMapping("/{day}/{month}/{year}")
    public int convertir(@PathVariable("day") Integer day, @PathVariable("month") Integer month, @PathVariable("year") Integer year){
        //return "El dia es: "+day+". El mes es:"+month;
        LocalDate now = LocalDate.now();

        int diff = year - now.getYear();
        if (now.getMonth() > month || (now.getMonth() == month && now.getDayOfMonth() > day)) {
            diff--;
        }
        return diff;


    }
}
