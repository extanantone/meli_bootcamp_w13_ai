package com.fecNac.demo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController



public class EdadController {


    @GetMapping("fecha/{dia}/{mes}/{year}")
    public Integer obtenerEdadDeFecha(@PathVariable("dia") Integer inDia,
                                      @PathVariable("mes") Integer inMes,
                                      @PathVariable("year") Integer inYear){

          Integer outEdad =0;
        LocalDate hoy = LocalDate.now();
        LocalDate diaDeNacimiento = LocalDate.of(inYear,inMes,inDia);

        if(hoy.getYear() - diaDeNacimiento.getYear() > 0 ){
            outEdad= hoy.getYear() - diaDeNacimiento.getYear() - 1;
            if(hoy.getMonthValue() > diaDeNacimiento.getMonthValue())
            {
                outEdad++;}
                else if (hoy.getMonthValue() == diaDeNacimiento.getMonthValue() && !(hoy.getDayOfMonth() < diaDeNacimiento.getDayOfMonth()))
                    outEdad++;
            }

        return outEdad;
    }
}
