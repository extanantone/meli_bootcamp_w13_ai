package com.w13.edadPersona.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EdadController {

    @GetMapping(path = "{dia}/{mes}/{anio}")
    public Integer obtenerEdadDeFecha(@PathVariable("dia") int inDia,
                                      @PathVariable("mes") int inMes,
                                      @PathVariable("anio") int inAnio) {

        LocalDate fechaNacimineto = LocalDate.of(inAnio, inMes, inDia);
        int fechaHoy = LocalDate.now().compareTo(fechaNacimineto);

        return fechaHoy;

    }


    @GetMapping("/holaMundo")
    ResponseEntity<String> holaMundo(){
        return ResponseEntity.ok("Hola Mundo !!");
    }


}
