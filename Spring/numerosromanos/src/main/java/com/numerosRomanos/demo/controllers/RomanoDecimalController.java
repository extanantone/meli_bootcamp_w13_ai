package com.numerosRomanos.demo.controllers;

import com.numerosRomanos.demo.logic.Conversor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanoDecimalController {
    Conversor conversor = new Conversor();
    @GetMapping("/romanodecimal/{romano}")
    public String romanoDecimal(@PathVariable("romano") String romano){
        return "Romano: " + romano +
                " Decimal: " + conversor.romanoDecimal(romano);
    }
}
