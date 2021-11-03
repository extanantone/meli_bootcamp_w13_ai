package com.example.bootcamp.controller;

import com.example.bootcamp.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {
    @GetMapping("/edad/")
    public static int calcularEdad (@RequestParam Integer dia, @RequestParam Integer mes, @RequestParam Integer año){
        return EdadService.calcularPorFecha(dia, mes, año);
    }
}