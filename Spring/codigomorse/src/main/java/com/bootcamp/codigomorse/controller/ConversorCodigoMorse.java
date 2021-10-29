package com.bootcamp.codigomorse.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ConversorCodigoMorse {
    
    @GetMapping("/{codigo}")
    public String conversorCodigoMorse(@PathVariable String codigo){
       return CodigoMorse.translate(codigo);

    }
    
    
}
