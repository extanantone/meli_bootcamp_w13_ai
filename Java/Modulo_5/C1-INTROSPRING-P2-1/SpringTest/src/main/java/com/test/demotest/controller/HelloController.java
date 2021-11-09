package com.test.demotest.controller;

import com.test.demotest.services.CodigoMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/{name}")
    public String HelloMundoController(@PathVariable String name){
        CodigoMorse codigoMorse = new CodigoMorse();

        return codigoMorse.convertMorse(name);
    }
}
