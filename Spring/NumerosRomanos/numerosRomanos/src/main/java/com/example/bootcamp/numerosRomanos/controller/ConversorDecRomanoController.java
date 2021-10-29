package com.example.bootcamp.numerosRomanos.controller;

import com.example.bootcamp.numerosRomanos.models.NumeroRomano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConversorDecRomanoController {

        @GetMapping("/{number}")
        public String convertIntegerToRoman(@PathVariable int number) {

            if (number > 0 && number < 3999) {

                String resultado = "";

                NumeroRomano numeroRomano = new NumeroRomano();
                resultado = numeroRomano.toRoman(number);


                return resultado;
            }

            return "El valor ingresado debe estar entre 0 y 3999";
        }



}
