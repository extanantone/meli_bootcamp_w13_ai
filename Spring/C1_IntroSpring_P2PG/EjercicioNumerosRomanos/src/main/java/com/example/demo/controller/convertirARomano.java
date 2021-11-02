package com.example.demo.controller;

import com.example.demo.models.NumerosRomanos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class convertirARomano {

    @GetMapping
    public String helloSpring() {
        return "Hola Spring!!";
    }

    @GetMapping("/{numero}")
    public String convertir(@PathVariable("numero") String numero){
        return NumerosRomanos.convertirARomano(Integer.parseInt(numero));
    }
}
