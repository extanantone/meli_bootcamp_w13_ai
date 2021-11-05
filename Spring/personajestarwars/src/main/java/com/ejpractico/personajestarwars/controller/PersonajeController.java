package com.ejpractico.personajestarwars.controller;

import com.ejpractico.personajestarwars.dto.PersonajeDTO;
import com.ejpractico.personajestarwars.service.IPersonajeService;

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
    final
    IPersonajeService personajeService;
    public PersonajeController(IPersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> getPersonaje(
        @PathVariable String nombre){
            return new ResponseEntity<>(personajeService.obtenerPersonaje(nombre),
                    HttpStatus.OK);
        }
    }

