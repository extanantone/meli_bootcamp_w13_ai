package com.bootcamp.C2P1EJ1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

@RestController
public class EdadConverterController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public static String devolverEdad(@PathVariable("dia") int dia,
                                      @PathVariable("mes") int mes,
                                      @PathVariable("anio") int anio) {
        if (dia > 31 || (dia>28 && mes==2)) {
            return "Día fuera de rango.";

        }
        if (mes > 12) {
            return "Mes fuera de rango.";
        }
        /*
        //PRIMER MANERA EN QUE HICE EL EJERCICIO:
        java.util.Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int edad = c.get(Calendar.YEAR) - anio;
        int mesActual = c.get(Calendar.MONTH);
        mesActual++;
        int diaActual = c.get(Calendar.DAY_OF_MONTH);

        if (mesActual < mes || (mesActual == mes && diaActual < diaActual)) {
            edad--;
        }
        */

        LocalDate start = LocalDate.of(anio, mes, dia);
        LocalDate stop = LocalDate.now(ZoneId.of("America/Argentina/Cordoba"));
        long edad = java.time.temporal.ChronoUnit.YEARS.between(start, stop);

        return "La edad es de: " + edad + ".";
    }
}
