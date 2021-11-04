package com.ejercicioEdad.ejercicio_edad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

@RestController
@RequestMapping("/api")
public class AgeController {



    @GetMapping(path = "/age")
    public String calculateAge(@RequestParam int day, @RequestParam int month,@RequestParam int year){
        LocalDate date= LocalDate.of(year,month,day);
        Period years=Period.between(date,LocalDate.now());
        return "es: "+years;

    }
}
