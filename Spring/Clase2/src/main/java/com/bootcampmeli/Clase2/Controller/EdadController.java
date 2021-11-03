package com.bootcampmeli.Clase2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
public class EdadController {
    @GetMapping("{dia}/{mes}/{year}")
    public String obtenerEdadFecha(@PathVariable("dia") Integer inDia,
                                   @PathVariable("mes") Integer inMes,
                                   @PathVariable("year") Integer inYear){


        LocalDateTime hoy = LocalDateTime.now();
        LocalDate diaDeNacimiento = LocalDate.of(inYear,inMes,inDia);
        long outEdad = diaDeNacimiento.until(hoy, ChronoUnit.YEARS);

        return "La edad es " + outEdad + " años";
    }


}
