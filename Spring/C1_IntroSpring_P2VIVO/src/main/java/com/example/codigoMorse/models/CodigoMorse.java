package com.example.codigoMorse.models;

import com.example.codigoMorse.controller.Morse.Morse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorse {

    @GetMapping
    public String getMorse(){
        return Morse.decodificarMorse("..-");
    }
}
