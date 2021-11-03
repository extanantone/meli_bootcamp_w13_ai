package com.bootcamp.demoWave13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping ("/{name}")
    public String sayHello(@PathVariable("name") String n){
        return "Hello " + n + "!";
    }

}
