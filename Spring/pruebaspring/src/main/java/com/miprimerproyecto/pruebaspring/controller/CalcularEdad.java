package com.miprimerproyecto.pruebaspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.Format;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
public class CalcularEdad {

    @GetMapping(path = "/calcularEdad/")
    public String  calculaedad(@RequestParam int dia,@RequestParam int mes,@RequestParam  int anno){

        LocalDate feHoy = LocalDate.now();
        LocalDate nacio = LocalDate.of(anno,mes,dia);
        Period peroido = Period.between(nacio,feHoy);

        return  "Tiene "+peroido.getYears()+" años "+peroido.getMonths()+" meses y " + peroido.getDays() + " dias";


    }

    @GetMapping(path = "/calcularEdadDate")
    public String calculaedad(@RequestParam   String date ){

        LocalDate nace = LocalDate.parse(date , DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate feHoy = LocalDate.now();
        Period peroido = Period.between(nace,feHoy);

        return  "Tiene "+peroido.getYears()+" años "+peroido.getMonths()+" meses " + peroido.getDays() + " dias";

    }
}
