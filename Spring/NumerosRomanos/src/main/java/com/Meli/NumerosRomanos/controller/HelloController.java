package com.Meli.NumerosRomanos.controller;

import com.Meli.NumerosRomanos.Service.RomanoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /*@GetMapping
    public String sayHello(){
        return "Hello Word!!!!!!!";
    }*/

    @GetMapping({"/Romanos"})
    public String getRomano(int numero){
        return RomanoService.IntegerToRomanNumeral(numero);
    }

}
