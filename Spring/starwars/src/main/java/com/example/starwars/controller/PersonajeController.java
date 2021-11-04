package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDto;
import com.example.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeController {
    //@Autowired
    IPersonajeService personajeService;

    public  PersonajeController (IPersonajeService personajeService){
        this.personajeService = personajeService;
    }
    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDto>>getPersonaje(@PathVariable String nombre){
        return new ResponseEntity<>(personajeService.obtenerPersonaje(nombre), HttpStatus.OK);
    }
}
