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
    public long obtenerEdadFecha(@PathVariable("dia") Integer inDia,
                                 @PathVariable("mes") Integer inMes,
                                 @PathVariable("year") Integer inYear){
        Integer outEdad = 0;
        LocalDateTime hoy = LocalDateTime.now();
        LocalDate diaDeNacimiento = LocalDate.of(inYear,inMes,inDia);
        return diaDeNacimiento.until(hoy, ChronoUnit.YEARS);
    }


}
