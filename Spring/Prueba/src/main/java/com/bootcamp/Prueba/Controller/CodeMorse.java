package com.bootcamp.Prueba.Controller;

import com.bootcamp.Prueba.Service.AbcMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeMorse {

    AbcMorse abcMorse = new AbcMorse();

    @GetMapping("/morse/{palabra}")
    public StringBuilder obtenerEquivalencias(@PathVariable String palabra) {
        return abcMorse.ObtenerMorse(palabra.toUpperCase());
    }

}