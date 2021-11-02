package com.introSpringP2.codigoMorse.controller;


import com.introSpringP2.codigoMorse.model.TraductorMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraductorMorseController {

    @GetMapping("traductorMorse/{codigo}")
    public String traducirAMorse(@PathVariable("codigo") String codigo){
        return TraductorMorse.traducir(codigo);
    }

}
