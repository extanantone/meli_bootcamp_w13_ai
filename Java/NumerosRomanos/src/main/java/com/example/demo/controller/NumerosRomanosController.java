package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping("/numerosRomanos/{nro}")
    public String devolverNumeroDecimal(@PathVariable() String nro){

        if(nro.equals("I"))
            return nro + " es: 1";

        if(nro.equals("II"))
            return nro + " es: 2";

        if(nro.equals("III"))
            return nro + " es: 3";

        if(nro.equals("IV"))
            return nro + " es: 4";

        if(nro.equals("V"))
            return nro + " es: 5";

        if(nro.equals("VI"))
            return nro + " es: 6";

        if(nro.equals("VII"))
            return nro + " es: 7";

        if(nro.equals("VIII"))
            return nro + " es: 8";

        if(nro.equals("IX"))
            return nro + " es: 9";

        if(nro.equals("X"))
            return nro + " es: 10";

        if(nro.equals("C"))
            return nro + " es: 50";

        return "No reconocido, asegurese de estar ingresando letras MAYUSCULAS";
    }
}
