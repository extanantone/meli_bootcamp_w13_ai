package com.example.date.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


@RestController

public class Age {



    @GetMapping("/{day}/{month}/{age}")

    public Integer getAge (@PathVariable("day") String day,
                           @PathVariable("month") String month,
                           @PathVariable("age") String year) {
        LocalDate bornDay = LocalDate.parse(year + "-" + month + "-" + day, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate now = LocalDate.now();

        Period period = Period.between(bornDay,now);

        return period.getYears();

    }
}
