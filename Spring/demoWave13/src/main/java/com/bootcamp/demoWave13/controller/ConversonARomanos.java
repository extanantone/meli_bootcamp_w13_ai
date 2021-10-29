package com.bootcamp.demoWave13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversonARomanos {

    @GetMapping("/{number}")
    public String conversorIntegerARomano(@PathVariable int number) {

        String resultado = "";

        NumerosRomanos numerosRomanos = new NumerosRomanos();
        resultado = numerosRomanos.convertRoman(number);


            return resultado;
        }
    }


