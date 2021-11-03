package com.edad.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.time.LocalDate;

@RestController
public class DateController {

    @GetMapping (path = "/{day}/{month}/{year}")
    public int GetAge(@PathVariable Integer day,
                         @PathVariable Integer month,
                         @PathVariable Integer year) {

        System.out.println(day + " " + month + " " + year);
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        int age = Period.between(birthDate, currentDate).getYears();

        return age;
    }
}
