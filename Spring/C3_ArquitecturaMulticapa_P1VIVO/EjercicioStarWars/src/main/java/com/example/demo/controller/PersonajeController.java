package com.example.demo.controller;

import com.example.demo.dto.PersonajeDTO;
import com.example.demo.service.IPersonajeService;
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

    IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService){
        this.personajeService = personajeService;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> searchByName(@PathVariable String nombre){
        return new ResponseEntity<>(personajeService.obtenerPersonajes(nombre), HttpStatus.OK);
    }
}
