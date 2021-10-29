package com.example.codigomorseapi.controller;

import com.example.codigomorseapi.service.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    private final CodigoMorseService codigoMorseService;

    public CodigoMorseController(CodigoMorseService codigoMorseService) {
        this.codigoMorseService = codigoMorseService;
    }

    @GetMapping("/{morse}")
    public String morseAPalabra(@PathVariable String morse) {
        return "Morse: " + morse + " / " + "Palabra: " + codigoMorseService.morseAPalabra(morse);
    }
}
