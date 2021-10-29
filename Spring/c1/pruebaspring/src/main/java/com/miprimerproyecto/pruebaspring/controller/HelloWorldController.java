package com.miprimerproyecto.pruebaspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/{name}")
    public String sayHelloName(@PathVariable("name") String name) {
        return "Hello " + name + "!!!";
    }

    @GetMapping()
    public String sayHelloWorld() {
        return "Hello world!!!";
    }
}
