package com.c2.p1vivo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class homeController {

    @GetMapping("/{day}/{month}/{year}")
    public Integer controller(@PathVariable Integer day,
                             @PathVariable Integer month,
                             @PathVariable Integer year){

        Integer actualYear = LocalDate.now().getYear();
        Integer actualMonth = LocalDate.now().getMonthValue();
        Integer actualDay = LocalDate.now().getDayOfMonth();
//        Integer edad = actualYear - year;
//        if (actualMonth - month < 0 || (actualMonth.equals(month) && actualDay < day))
//            edad -= 1;
//        return edad;
        return (actualMonth - month < 0 || (actualMonth.equals(month) && actualDay < day)) ? actualYear - year - 1 : actualYear - year;
    }
}
