package com.bootcamp.edaddeunapersona.controller;

import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("api/v1/edad")
public class EdadPersonaController {

    //http://localhost:8080/api/v1/edad/30/08/1995
    @GetMapping("/{dia}/{mes}/{anio}")
    public String getEdadPV(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        return calcularEdad(dia, mes, anio);
    }

    //http://localhost:8080/api/v1/edad?dia=20&mes=04&anio=1998
    @GetMapping()
    public String getEdadRP(@RequestParam Integer dia, @RequestParam Integer mes, @RequestParam Integer anio){
        return calcularEdad(dia, mes, anio);
    }

    //http://localhost:8080/api/v1/edad/
    @PostMapping()
    public String getEdadRB(@RequestBody Fecha fecha){
        return calcularEdad(fecha.getDia(), fecha.getMes(), fecha.getAnio());
    }

    private String calcularEdad(Integer day, Integer month, Integer year){
        String mensaje = "La edad de la persona es ";
        LocalDate fechaNacimiento;
        Period periodo;

        try{
            fechaNacimiento = LocalDate.of(year, month, day);
        }catch (DateTimeException exp){
            return exp.getMessage();
        }

        periodo = Period.between(fechaNacimiento, LocalDate.now());

        if(periodo.getYears() > 0){
            mensaje += periodo.getYears() + " años";
        }else if(periodo.getMonths() > 0){ //si no llega al año devuelvo los meses
            mensaje += periodo.getMonths() + " meses";
        }else if(periodo.getDays() > 0){
            mensaje += periodo.getDays() + " dias";
        }else {
            mensaje = "La persona todavia no ha nacido";
        }

        return  mensaje;
    }
}
