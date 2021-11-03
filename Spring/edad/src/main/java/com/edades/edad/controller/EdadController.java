package com.edades.edad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@RestController
public class EdadController {

    @GetMapping("/edades/{dia}/{mes}/{anio}")
    public ResponseEntity<String> calcularEdad(@PathVariable() String dia, @PathVariable() String mes, @PathVariable() String anio) throws ParseException {

        LocalDate dateNow =  LocalDate.now();

        int diaInt = Integer.parseInt(dia);
        int mesInt = Integer.parseInt(mes);
        int anioInt = Integer.parseInt(anio);

        if(diaInt <= 0)
            return ResponseEntity.badRequest().body("El dia debe ser mayor a 0");

        if(mesInt <= 0 || mesInt > 12)
            return ResponseEntity.badRequest().body("El mes debe ser mayor a 0 y menor o igual a 12");

        if(anioInt < 1400 || anioInt > dateNow.getYear())
            return ResponseEntity.badRequest().body("El anio debe ser mayor a 1400 y menor o igual a " + dateNow.getYear());


        LocalDate birthDay = LocalDate.of(anioInt, mesInt, diaInt);

        Period p = Period.between(birthDay, dateNow);

        return ResponseEntity.status(200)
                             .body("Tenés " + String.valueOf(p.getYears()) + " años");

    }
}
