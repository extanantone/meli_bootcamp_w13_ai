package com.bootcamp.wave13.controller;

import com.bootcamp.wave13.model.Numero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping
    public String sayHello(){
        return "Helloo World :D";
    }

    @GetMapping("/{numero}")
    public String becomeRomanNumber(@PathVariable("numero") Integer n){
        Numero numero=new Numero(n);
        return "El numero "+n+" en romano es "+numero.toRoman();
    }


}
