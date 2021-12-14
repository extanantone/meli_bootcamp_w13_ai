package com.bootcamp.demo.demo.controller;

import com.bootcamp.demo.demo.model.NumeroDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {
    @GetMapping("/{num}")
    public static String decimalARomano(@PathVariable Integer num){
        NumeroDecimal numeroDecimal = new NumeroDecimal(num);
        return numeroDecimal.aRomano();
    }
}
