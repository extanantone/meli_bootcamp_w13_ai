package com.practicaAnotaciones.edadPersona.controller;

import com.practicaAnotaciones.edadPersona.Fecha;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class EdadController {
    @GetMapping("path/{dia}/{mes}/{anio}")
    public String calcularEdadPath(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(dia+"/"+mes+"/"+anio, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        return "Su edad es "+periodo.getYears();
    }

    @GetMapping("request")
    public String calcularEdadRequest(@RequestParam String dia, @RequestParam String mes, @RequestParam String anio){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(dia+"/"+mes+"/"+anio, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        return "Su edad es "+periodo.getYears();
    }

    @PostMapping("post")
    private static String calcularEdadPayload(@RequestBody Fecha fecha) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fecha.getDia()+"/"+fecha.getMes()+"/"+fecha.getAnio(), fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        return "Su edad es "+periodo.getYears();
    }
}
