package com.bootcamp.demoWave13.controller;

import com.bootcamp.demoWave13.Service.AbcMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

@RestController
public class CodMorse {

    AbcMorse abcMorse = new AbcMorse();

    @GetMapping("/morse/{palabra}")
    public String obtenerEquivalencias(@PathVariable String palabra) {

        return abcMorse.ObtenerMorse(palabra.toUpperCase());
    }

}
