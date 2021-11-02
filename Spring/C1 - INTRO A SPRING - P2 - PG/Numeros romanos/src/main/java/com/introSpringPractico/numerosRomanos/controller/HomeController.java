package com.introSpringPractico.numerosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/numerosRomanos/{numero}")
    public String toRomano(@PathVariable("numero") int numero){
        if(numero < 1 || numero > 3999) {
            return "No es posible convertir este numero";
        }

        int i, miles, centenas, decenas, unidades;
        String romano = "";

        miles = numero / 1000;
        centenas = numero / 100 % 10;
        decenas = numero / 10 % 10;
        unidades = numero % 10;

        for (i = 1; i <= miles; i++) {
            romano+= "M";
        }

        if (centenas == 9) {
            romano+= "CM";
        } else if (centenas >= 5) {
            romano+= "D";
            for (i = 6; i <= centenas; i++) {
                romano+= "C";
            }
        } else if (centenas == 4) {
            romano+= "CD";
        } else {
            for (i = 1; i <= centenas; i++) {
                romano+= "C";
            }
        }

        if (decenas == 9) {
            romano+= "XC";
        } else if (decenas >= 5) {
            romano+= "L";
            for (i = 6; i <= decenas; i++) {
                romano+= "X";
            }
        } else if (decenas == 4) {
            romano+= "XL";
        } else {
            for (i = 1; i <= decenas; i++) {
                romano+= "X";
            }
        }

        if (unidades == 9) {
            romano+= "IX";
        } else if (unidades >= 5) {
            romano+= "V";
            for (i = 6; i <= unidades; i++) {
                romano+= "I";
            }
        } else if (unidades == 4) {
            romano+= "IV";
        } else {
            for (i = 1; i <= unidades; i++) {
                romano+= "I";
            }
        }

        return numero+"->"+romano;
    }
}
