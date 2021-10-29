package com.example.bootcamp.CodigoMorse.controller;

import com.example.bootcamp.CodigoMorse.CodigoMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    @GetMapping("/{codigomorse}")
    public String convertIntegerToRoman(@PathVariable String codigomorse) {

        if(codigomorse.length() > 0) {
            CodigoMorse cm = new CodigoMorse();
            return cm.convertMorseToPhrase(codigomorse);
        }

        return "Debe ingresar caracteres para que sean convertidos de codigo morse a texto.";
    }


}
