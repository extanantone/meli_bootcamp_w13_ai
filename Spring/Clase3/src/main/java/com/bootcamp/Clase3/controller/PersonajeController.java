package com.bootcamp.Clase3.controller;

import com.bootcamp.Clase3.dto.PersonajeDTO;
import com.bootcamp.Clase3.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeController {


    IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService){
        this.personajeService = personajeService;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(@PathVariable  String nombre){
        return new ResponseEntity<>(personajeService.obtenerPersonaje(nombre), HttpStatus.OK);


    }

}
