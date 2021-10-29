package com.example.morse.controllers;

import com.example.morse.services.MorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseRestController {

    @GetMapping("/{morse}")
    public String toString(@PathVariable String morse){

        if(morse == null || morse.isEmpty()) return "El codigo morse no puede ser vacio ni nulo.";

        return MorseService.toString(morse);
    }
}
