package com.C1P2.NumerosRomanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecimalARomano {

    @GetMapping("/{decimal}")
    public String convertirDecimalARomano(@PathVariable int decimal) {
        int numeroOrignal = decimal;

        String romanNumbers[] = {"M", "CMXC", "CM", "D", "CDXC", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int arab[] = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (decimal > 0 || arab.length == (i - 1)) {
            while ((decimal - arab[i]) >= 0) {
                decimal -= arab[i];
                result.append(romanNumbers[i]);
            }
            i++;
        }
        return "El número: " + numeroOrignal + " en romano es: " + result.toString();

    }
}
