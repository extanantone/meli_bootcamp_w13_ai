package com.bootcamp.demoWave13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping()
    public String sayHello(){
        return "Hola soy Ale!";
    }

    @GetMapping("/{name}")
    public String sayHelloName(@PathVariable("name") String nombre){
        return "Hola " + nombre + "!";
    }
}
