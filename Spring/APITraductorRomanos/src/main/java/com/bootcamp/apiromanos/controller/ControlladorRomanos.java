package com.bootcamp.apiromanos.controller;

import com.bootcamp.apiromanos.model.DiccionarioRomanos;
import com.bootcamp.apiromanos.model.TraductorRomanos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlladorRomanos {

    @GetMapping("/{n}")
    public String devolverRomano(@PathVariable int n){

        DiccionarioRomanos dr = new DiccionarioRomanos();

        TraductorRomanos tr = new TraductorRomanos(n);

        String salida = tr.getRomano();

        return salida;
        //return "Decimal : " + n + " , Romano: " + dr.getRomano(n);
    }

}
