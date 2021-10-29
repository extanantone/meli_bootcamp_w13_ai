package com.bootcamp.numerosromanos.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class NumerosRomanosController {

    @PostMapping("/post")
    public String convertToRomanPost(@RequestBody String numero){
        return convertirDecimalRomano(Integer.parseInt(numero));
    }

    @GetMapping("/{numero}")
    public String convertToRomanGet(@PathVariable Integer numero){
        return convertirDecimalRomano(numero);
    }

    private String convertirDecimalRomano(Integer numDecimal){
        Integer[] numerosDecimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String numRomano = "";
        int i = 0;
        int decimal = numDecimal;

        if((numDecimal < 1) || (numDecimal > 1000)){
            return "Este sistema no admite numeros decimales mayores que 1000 ni menores a 1";
        }

        while(numDecimal > 0) {
            while(0 < (numDecimal / numerosDecimales[i])){
                numRomano += numerosRomanos[i];
                numDecimal -= numerosDecimales[i];
            }
            i += 1;
        }

        return "El numero " + decimal + " en romano es " + numRomano;
    }
}
