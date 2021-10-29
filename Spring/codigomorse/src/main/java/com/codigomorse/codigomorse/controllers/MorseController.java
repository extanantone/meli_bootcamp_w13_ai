package com.codigomorse.codigomorse.controllers;

import com.codigomorse.codigomorse.logica.ConversorMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {
    ConversorMorse conversor = new ConversorMorse();
    @GetMapping("/morse/{code}")
    public String romanoDecimal(@PathVariable("code") String code){
        return "Codigo: " + code + " Traduccion: " + conversor.convertir(code);
    }
}
