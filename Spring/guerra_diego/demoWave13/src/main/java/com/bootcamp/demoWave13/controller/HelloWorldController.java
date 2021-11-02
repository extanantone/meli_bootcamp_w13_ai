package com.bootcamp.demoWave13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.bootcamp.demoWave13.controller.Romanos.methodOne;

@RestController
public class HelloWorldController {

    @GetMapping("/{morse}")
    public String sayHello(@PathVariable String morse){
        return "Morse "+morse;

        //return "El numero "+decimal +" corresponde a "+methodOne(decimal) + " en romano";

    }
}
