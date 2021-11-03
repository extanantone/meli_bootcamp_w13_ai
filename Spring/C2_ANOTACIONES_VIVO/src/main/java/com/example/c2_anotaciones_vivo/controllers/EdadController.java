package com.example.c2_anotaciones_vivo.controllers;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@RestController
@Validated
public class EdadController
{
    @GetMapping("/{day}/{month}/{year}")
    public String Edad(@PathVariable @Min(1) @Max(31) int day,
                       @PathVariable @Min(1) @Max(12) int month,
                       @PathVariable int year)
    {

        LocalDate userDate = LocalDate.now();
        try
        {
            userDate = LocalDate.of(year, month, day);
        }
        catch (DateTimeException error)
        {
            return (error.toString());
        }
        LocalDate actualDate = LocalDate.now();
        int edad = Period.between(userDate, actualDate).getYears();
        return "La edad es: " + edad + " años";
    }
}
