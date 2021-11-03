package com.bootcamp.edadPersona.controller;

import com.bootcamp.edadPersona.modelo.Edad;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;


@RestController
public class EdadController {

    @GetMapping("/edad")
    public String getEdad(@RequestBody Edad edadPer){

        Period edad=Period.between(LocalDate.of(edadPer.getAño(), edadPer.getMes(), edadPer.getDia()),LocalDate.now());

        return "Tienes: "+edad.getYears()+" años, "+edad.getMonths()+" meses y "+edad.getDays()+" dias";
    }

}
