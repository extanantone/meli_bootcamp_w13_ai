package com.c3.p1.controller;

import com.c3.p1.dto.PersonajeDto;
import com.c3.p1.service.IPersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonajeController {
    IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService){
        this.personajeService = personajeService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDto>> getPersonajes(@PathVariable String name){
        return new ResponseEntity<>(personajeService.buscarPersonaje(name), HttpStatus.OK);
    }
}
