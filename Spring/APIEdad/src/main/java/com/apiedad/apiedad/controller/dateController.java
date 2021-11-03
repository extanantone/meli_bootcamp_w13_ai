package com.apiedad.apiedad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api/date")
public class dateController {

//url/api/date/{day}/{month}/{year}
    @GetMapping(path = "/{day}/{month}/{year}")
    public String read(@PathVariable int day,
                       @PathVariable int month,
                       @PathVariable int year){

        LocalDate now = LocalDate.now();

        LocalDate past = LocalDate.of(year,month,day);

       // int edad = now.getYear() - past.getYear();

        return "edad : " + past.until(now).getYears();
    }


}
