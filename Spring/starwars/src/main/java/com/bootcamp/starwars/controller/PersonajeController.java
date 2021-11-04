package com.bootcamp.starwars.controller;


import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeController {

    IPersonajeService personajeService;


    public PersonajeController(IPersonajeService personajeService) {
        this.personajeService = personajeService;

    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(@PathVariable String name){
        return new ResponseEntity<>(personajeService.obtenerPersonaje(name), HttpStatus.OK);
    }
}
