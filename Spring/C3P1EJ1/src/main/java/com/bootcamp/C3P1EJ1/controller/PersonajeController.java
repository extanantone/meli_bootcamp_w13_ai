package com.bootcamp.C3P1EJ1.controller;

import com.bootcamp.C3P1EJ1.dto.PersonajeDTO;
import com.bootcamp.C3P1EJ1.service.PersonajeServiceInterfaz;
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

    PersonajeServiceInterfaz personajeService;

    public PersonajeController(PersonajeServiceInterfaz psi){
        this.personajeService = psi;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> mostrarPersonaje(@PathVariable("name") String name) {
        return new ResponseEntity<>(personajeService.obtenerPersonaje(name), HttpStatus.OK);
    }

}
