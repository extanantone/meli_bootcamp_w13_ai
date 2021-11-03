package com.apiedad.apiedad.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/date")
public class dateController {

//url/api/date/{day}/{month}/{year}
    @GetMapping(path = "/{day}/{month}/{year}")
    public ResponseEntity<?> read(@PathVariable int day,
                       @PathVariable int month,
                       @PathVariable int year){

        LocalDate now = LocalDate.now();

        LocalDate past = LocalDate.of(year,month,day);

        return (past.isBefore(now)) ? ResponseEntity.ok()
                .header("Calculadora Edad", "Entrada :" + + day + "-" + month + "-" + year)
                .body("Edad : " + past.until(now).getYears())
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La fecha ingresada corresponde a un punto futuro en el tiempo.");

    }

//url/api/date/

    @GetMapping()
    public ResponseEntity<?> calcular(@RequestParam int day,
                                      @RequestParam int month,
                                      @RequestParam int year){

        HttpHeaders head = new HttpHeaders();

        head.add("Calculo Edad","Entradas : " + day + "/" + month + "/" + year);

        LocalDate now = LocalDate.now();

        LocalDate past = LocalDate.of(year,month,day);

        return (past.isBefore(now)) ? ResponseEntity.ok().headers(head).body("Edad : " + past.until(now).getYears())
                : ResponseEntity.badRequest().body("La fecha ingresada corresponde a un punto futuro en el tiempo.");
    }



}
