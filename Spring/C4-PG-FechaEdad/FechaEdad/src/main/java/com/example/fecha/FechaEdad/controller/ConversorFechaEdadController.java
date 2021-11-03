package com.example.fecha.FechaEdad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/conversoredad")
public class ConversorFechaEdadController {

    @GetMapping(path = "{day}/{month}/{year}")
    public int convertDateToAge (@PathVariable String day,
                            @PathVariable String month,
                            @PathVariable Integer year) {

        LocalDate birthDate;
        int cDay = Integer.valueOf(day);
        int cMonth = Integer.valueOf(month);
        int cYear = Integer.valueOf(year);

        try {
            birthDate = LocalDate.of(cYear, cMonth, cDay);
        }
        catch(Exception e){
            return -1;
        }

        return Period.between(birthDate, LocalDate.now()).getYears();

    }


}
