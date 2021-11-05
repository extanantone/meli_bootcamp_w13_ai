package com.example.star_wars.controller;

import com.example.star_wars.dto.PersonajeDTO;
import com.example.star_wars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")

public class PersonajeController {

//    @Autowired
    IPersonajeService personajeService;

    public personajeController(IPersonajeService personajeService){
        this.personajeService = personajeService;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(@RequestParam String nombre){
        return new ResponseEntity<>(
                personajeService.obtenerPersonaje(nombre),
                HttpStatus.OK
        );

    }
}
