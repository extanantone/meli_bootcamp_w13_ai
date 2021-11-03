package com.c2spring.ejercicio;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/")
public class controllers {


    @GetMapping
    public String saludar(){
        return "funciono bien!";
    }

    @GetMapping("/usuarios")
    public Usuarios hola(@RequestParam("id") Integer id, @RequestParam("nombre") String nombre){
        Usuarios user = new Usuarios();
        user.setId(id);
        user.setNombre(nombre);
        return user;
    }

    @GetMapping("/usuarios/edad")
    public String edadUsuario(@RequestParam("dia") Integer dia, @RequestParam("mes") Integer mes, @RequestParam("ano") Integer ano){
        Period rango = Period.between(LocalDate.of(ano,mes,dia),LocalDate.now());
        return String.format("%d dias %d meses %d años",rango.getDays(),rango.getMonths(),rango.getYears());
    }

}
