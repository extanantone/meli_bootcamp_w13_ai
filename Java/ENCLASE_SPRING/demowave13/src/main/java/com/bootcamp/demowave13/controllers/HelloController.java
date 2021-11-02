package com.bootcamp.demowave13.controllers;

import com.bootcamp.demowave13.logica.Morse;
import com.bootcamp.demowave13.logica.NumerosRomanos;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/saludo/{nombre}")
    @ResponseBody
    public String sayHello(@PathVariable String nombre, @RequestParam String id){
        return "Hola " + nombre +" id:"+ id;
    }


    @GetMapping("/morse2espanol/{frase}")
    public String morse2espanol(@PathVariable String frase){
        return Morse.traductor(frase);
    }

    @GetMapping("/espanol2morse/{frase}")
    public String espanol2morse(@PathVariable String frase){
        return Morse.traductorReverse(frase);
    }


    @GetMapping("/romano/{numero}")
    @ResponseBody
    public String sayHello(@PathVariable Integer numero){
        return NumerosRomanos.decimalARomano(numero);
    }




    @GetMapping()
    public String sayHello(){
        return "Hola base" ;
    }
}
