package com.example.edadpersona.controllers;

import com.example.edadpersona.services.EdadPersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadPersonaController {

    @GetMapping("/{day}/{month}/{year}")
    public Integer getEdad(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
        return EdadPersonaService.getEdad(day,month,year);
    }
}
