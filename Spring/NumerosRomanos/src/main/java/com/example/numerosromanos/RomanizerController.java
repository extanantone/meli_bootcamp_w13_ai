package com.example.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanizerController {

    @GetMapping("/{number}")
    public String romanizer(@PathVariable int number) {
        if (number > 3999 || number < 1) {
            return "El número " + number + " no puede pasarse a romano.";
        }
        return ConversorRomano.toRoman(number);
    }
}
