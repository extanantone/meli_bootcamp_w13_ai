package com.mercadolibre.ejercicio1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;

@RestController
public class HelloWorldController {
    @GetMapping("/{number}")
    public String normalizeNumber(@PathVariable("number") int number) {

        //String[] response= new String[];
        if (number > 40000){
            return "Ingrese un numero entre 1 y 39999";
        } else {
            String[] infoMiles= {"M'X", "'V", "M", "M'V", "M"};
            String[] infoCentenas= {"CM", "D", "C", "CD", "C"};
            String[] infoDecenas= {"XC", "L", "X", "XL", "X"};
            String[] infoUnidades= {"IX", "V", "I",  "IV", "I"};
            int i, diezMiles, miles, centenas, decenas, unidades;
            String romanNumber = "";
            diezMiles = number / 10000;
            miles = number / 1000 % 10;
            centenas = number / 100 % 10;
            decenas = number / 10 % 10;
            unidades = number % 10;

            for (i = 1; i <= diezMiles; i++) {
                romanNumber += "'X";
            }

            romanNumber= this.recursiveNumber(miles, romanNumber, infoMiles);
            romanNumber= this.recursiveNumber(centenas, romanNumber, infoCentenas);
            romanNumber= this.recursiveNumber(decenas, romanNumber, infoDecenas);
            romanNumber= this.recursiveNumber(unidades, romanNumber, infoUnidades);

            String responseMessage= "El numero " + number + " en romano es: " + romanNumber;

            if (number > 4000)
                responseMessage+= "\n Atencion: El numero excede las 4000 unidades y no hay codigo ASCII para las letra " +
                        "romanas que representan los miles";

            return responseMessage;
        }
    }
    
    public String recursiveNumber(int unidades, String romanNumber, String[] arrayRomans){
        int i;
        if (unidades == 9) {
            romanNumber += arrayRomans[0];
        } else if (unidades >= 5) {
            romanNumber += arrayRomans[1];
            for (i = 6; i <= unidades; i++) {
                romanNumber += arrayRomans[2];
            }
        } else if (unidades == 4) {
            romanNumber += arrayRomans[3];
        } else {
            for (i = 1; i <= unidades; i++) {
                romanNumber += arrayRomans[4];
            }
        }
        return romanNumber;
    }
}
