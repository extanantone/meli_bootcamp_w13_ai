package com.numerosRomanos.demo.controllers;
import com.numerosRomanos.demo.logic.Conversor;
import org.springframework.web.bind.annotation.*;

@RestController
public class DecimalRomanoController {
    Conversor conversor = new Conversor();
    @GetMapping("/decimalromano/{decimal}")
    public String hi(@PathVariable("decimal") int decimal){
        return "Decimal: " + decimal +
        " Romano: " + conversor.decimalRomano(decimal);
    }
}
