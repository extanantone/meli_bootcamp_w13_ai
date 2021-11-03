package com.dates.dates.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;

@RestController
public class DateController {

    @GetMapping("/{day}/{mount}/{year}")
    public String getDate(@PathVariable int day, @PathVariable int mount,@PathVariable int year){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime valid =LocalDateTime.of(year,mount,day,0,0);
        return ""+ Duration.between(valid,now).toDays()/365;
    }

}
