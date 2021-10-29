package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Romano {

    public String ordenarRomano (Integer numero,String inferior,String intermedio,String superior) {

        String romano = "";
        int i = 0;
        if(numero == 9) {
            romano = romano + inferior + superior;

        } else if (numero >= 5) {
            romano = romano + intermedio;
            for (i=6;i<=numero;i++){
                romano = romano + inferior;
            }
        } else if (numero == 4) {
            romano = romano + inferior + intermedio;
        } else {
            for (i = 1; i <= numero ; i++) {
                romano = romano + inferior;
            }
        }
        return romano;
    }

    @GetMapping("/romano/{numero}")
    public String convertirDecimal (@PathVariable("numero") String numero) {
        Integer num = Integer.parseInt(numero);

        if(num == 0) {
            return "0 no es un numero Romano";
        }

        String romano = "";
        Integer milesimas = num/1000;
        Integer centecimas = num/100%10;
        Integer decimas = num/10%10;
        Integer unidades = num%10;
        int i = 0;

        /// milesimas
        for (i = 1; i < milesimas; i++) {
            romano = romano + "M";
        }

        // centecimas
        romano = romano + ordenarRomano(centecimas,"C","D","M");

        // decimas

        romano = romano + ordenarRomano(decimas,"X","L","C");

        // unidades

        romano = romano + ordenarRomano(unidades,"I","V","X");



        return  "El numero romano es: " + romano;

    }
}
