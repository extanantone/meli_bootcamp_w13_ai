package com.DTO.StarWars.controller;

import com.DTO.StarWars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonajeController {

    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/getPersonaje/{name}")
    public ResponseEntity<?> getPersonajeByName(@PathVariable String name){
        return new ResponseEntity<>(personajeService.getPersonajeByName(name), HttpStatus.OK);
    }
}
