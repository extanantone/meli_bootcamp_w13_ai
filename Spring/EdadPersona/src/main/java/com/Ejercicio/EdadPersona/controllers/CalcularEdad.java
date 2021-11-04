package com.Ejercicio.EdadPersona.controllers;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@Setter
@Getter
public class CalcularEdad {


    @GetMapping( "edad/{day}/{month}/{year}")

    public String CalcularEdad (@PathVariable int day,
                                @PathVariable int month,
                                @PathVariable int year)
    {
        LocalDate yearPersona = LocalDate.of(year,month,day);
        LocalDate today = LocalDate.now();

        Period period = Period.between(yearPersona, today);


        System.out.println(yearPersona);
        System.out.println(today);
        System.out.println(period);
        return "La edad de la persona es : " + period.getYears();
    }
}
