package com.miprimerproyecto.pruebaspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumberController {
    @GetMapping("/{decimalNumber}")
    public String sayHello(@PathVariable("decimalNumber") Integer decimalNumber) {
        if (decimalNumber < 0 || decimalNumber > 3999) {
            return "El numero debe ser mayor a 0 y menor que 4000";
        } else {
            return "El número " + decimalNumber + " en números Romanos es: " + toRoman(decimalNumber);
        }
    }

    private String toRoman(Integer decimalNumber) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI",
                "VII", "VIII", "IX", "X"};

        int numberOfThousands = decimalNumber / 1000;
        int numberOfHundreds = (decimalNumber / 100) % 10;
        int numberOfTens = (decimalNumber / 10) % 10;
        int numberOfUnits = decimalNumber % 10;

        String romanNumber = thousands[numberOfThousands] + hundreds[numberOfHundreds]
                + tens[numberOfTens] + units[numberOfUnits];

        return romanNumber;
    }
}
