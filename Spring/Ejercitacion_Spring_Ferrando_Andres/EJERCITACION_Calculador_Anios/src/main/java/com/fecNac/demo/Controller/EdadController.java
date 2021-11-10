package com.fecNac.demo.Controller;


import com.fecNac.demo.Service.Calculador;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController



public class EdadController {


    Calculador calculador = new Calculador();

    @GetMapping("fecha/{dia}/{mes}/{year}")
    public Integer obtenerEdadDeFecha(@PathVariable("dia") Integer inDia,
                                      @PathVariable("mes") Integer inMes,
                                      @PathVariable("year") Integer inYear){

        return calculador.calcularEdad(inDia,inMes,inYear);


    }
}
