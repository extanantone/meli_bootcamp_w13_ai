package com.mercadolibre.numerosromanos.controller;

import com.mercadolibre.numerosromanos.Sevice.ConvertirNumeros;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovertirNRController {
    ConvertirNumeros convertirNumeros = new ConvertirNumeros();
    @GetMapping("/romanoadecimal/{numeroRomano}")
    public int convertirNumeroRomano(@PathVariable String numeroRomano){
        int response = convertirNumeros.convertirLetraANumero(numeroRomano);
        return response;
    }
    @GetMapping("/decimalaromano/{numeroRomano}")
    public int convertirNumeroDecimalRomano(@PathVariable String numeroRomano){
        int response = convertirNumeros.convertirLetraANumero(numeroRomano);
        return response;
    }

}
