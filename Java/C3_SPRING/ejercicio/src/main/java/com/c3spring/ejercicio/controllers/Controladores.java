package com.c3spring.ejercicio.controllers;

import com.c3spring.ejercicio.dto.PersonajeDTO;
import com.c3spring.ejercicio.servicio.IBuscable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personajes")
public class Controladores {

    // esto es una instancia pero la crea el framework
    // inyeccion de dependencias
    // aplicando inversion de control
    IBuscable personajesService;

    // s epeude de dos formas usando Autowired o usando el constructor
    public Controladores(IBuscable personajesService)
    {
        this.personajesService = personajesService;
    }

    @GetMapping("/")
    public String hola(){
        return "Hola mundo";
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> buscarPersonajes(@PathVariable("nombre") String nombre){
        List<PersonajeDTO> lista = personajesService.encontrar(nombre);
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }
}
