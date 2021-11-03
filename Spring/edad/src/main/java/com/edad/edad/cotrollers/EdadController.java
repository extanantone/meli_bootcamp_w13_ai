package com.edad.edad.cotrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EdadController {
    @GetMapping("{day}/{month}/{year}")
    public Integer edadController(@PathVariable Integer year,
                                   @PathVariable Integer month,
                                   @PathVariable Integer day) {
        Integer outAge = 0;
        LocalDate today = LocalDate.now();
        LocalDate birth = LocalDate.of(year, month, day);

        if(today.getYear() - birth.getYear() > 0){
            outAge = today.getYear() - birth.getYear() -1;
            if(today.getMonthValue() > birth.getMonthValue()) outAge++;
            else if (today.getMonthValue() == birth.getMonthValue() &&
                    !(today.getDayOfMonth() < birth.getDayOfMonth())) outAge++;
            }
        return outAge;
    }
}