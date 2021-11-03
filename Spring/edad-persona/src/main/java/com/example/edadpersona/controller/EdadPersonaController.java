package com.example.edadpersona.controller;

import com.example.edadpersona.service.EdadPersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadPersonaController {

    private final EdadPersonaService edadPersonaService;

    public EdadPersonaController(EdadPersonaService edadPersonaService) {
        this.edadPersonaService = edadPersonaService;
    }

    @GetMapping("/{dia}/{mes}/{anio}")
    public String edadPersona(@PathVariable int dia,
                              @PathVariable int mes,
                              @PathVariable int anio) {
        return edadPersonaService.getEdadPersona(dia, mes, anio);
    }
}
