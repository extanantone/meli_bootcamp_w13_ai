package com.mercadolibre.anotaciones.controller;

import com.mercadolibre.anotaciones.dominio.Edad;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;


@RestController
public class DateController {
    //http://localhost:8080/?dia=11&mes=02&anio=1990
    @GetMapping()
    public String fechaNacimiento(@RequestParam Integer dia,
                                @RequestParam Integer mes,
                                @RequestParam Integer anio){

        Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
        return String.format("%d años, %d meses y %d días",
                edad.getYears(),
                edad.getMonths(),
                edad.getDays());

    }
   // http://localhost:8080/persona/edad/03/11/1994
    @GetMapping("/persona/edad/{dia}/{mes}/{anio}")
    public String edadPersona(@PathVariable Integer dia,
                                  @PathVariable Integer mes,
                                  @PathVariable Integer anio){
        Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
        return String.format("%d años", edad.getYears());
    }

    //http://localhost:8080/edad/03/11/1994
    @GetMapping("/edad/{dia}/{mes}/{anio}")
   // @ResponseBody No es necesario ya esta explicito en el Controller
    public Edad obtenerEdad(@PathVariable Integer dia,
                            @PathVariable Integer mes,
                            @PathVariable Integer anio){
        Edad edad = new Edad(dia,mes,anio);
        Period calcularEdad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
        edad.setEdad(calcularEdad.getYears());
        return edad;
    }


}
