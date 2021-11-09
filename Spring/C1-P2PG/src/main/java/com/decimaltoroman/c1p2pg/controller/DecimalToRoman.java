package com.decimaltoroman.c1p2pg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecimalToRoman {
    @GetMapping
    public String homepage(){
        return "Ingrese a '/' y luego un numero que desea convertir a romano";
    }
    @GetMapping("/api/{number}")
    public String decimalToRoman(@PathVariable String number){
        String result = Converter.converter(number);
        return result;
    }
}
