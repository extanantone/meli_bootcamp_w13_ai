package com.Romanos.nroRomanos.Controller;


import com.Romanos.nroRomanos.Service.NrosRomanosANrosDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosController {

    NrosRomanosANrosDecimal conversor = new NrosRomanosANrosDecimal();

    @GetMapping("/romanos/{numero}")
    public String devolverRomano (@PathVariable Integer numero)
    {
        return conversor.conversorDecRom(numero);

    }
}
