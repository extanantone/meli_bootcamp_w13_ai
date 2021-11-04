package com.starwars.controller;

import com.starwars.dto.PersonajeDto;
import com.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars/personajes")
public class PersonajeController {

    @Autowired
    private IPersonajeService service;

    @GetMapping("/{name}")
    public ResponseEntity<?> getPersonaje(@PathVariable String name){
        List<PersonajeDto> dtos = service.getPersonajesByName(name);
        return ResponseEntity.ok(dtos);
    }

}
