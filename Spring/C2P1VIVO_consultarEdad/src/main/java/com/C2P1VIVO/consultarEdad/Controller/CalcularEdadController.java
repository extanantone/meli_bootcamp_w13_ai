package com.C2P1VIVO.consultarEdad.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;

@RestController
public class CalcularEdadController {

    @GetMapping("/{day}/{month}/{year}")
    public Integer calcularEdad(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        Integer edad = 0;

        LocalDate currentDate = LocalDate.now();
        LocalDate bDate = LocalDate.of(year, month, day);

        edad = (int)(currentDate.compareTo(bDate));

        return edad;
    }
}
