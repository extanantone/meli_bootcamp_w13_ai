package com.MeliBoot.CodigoMorse.controllers;

import com.MeliBoot.CodigoMorse.services.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    private static CodigoMorseService codigoMorseService;

    public CodigoMorseController(CodigoMorseService codigoMorseService) {
        this.codigoMorseService = codigoMorseService;
    }

    @GetMapping("/{codigoMorse}")
    public static String obtenerEquivalencias(@PathVariable ("codigoMorse") String codigoMorse) {
            return "Palabra: " + codigoMorseService.morseAPalabra(codigoMorse) + "- Codigo Morse: " + codigoMorse;
    }
}
