package com.starwars.controller;

import com.starwars.dto.PersonajeDto;
import com.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starwars/personajes")
public class PersonajeController {

    @Autowired
    private IPersonajeService service;

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PersonajeDto> getPersonaje(@PathVariable String name){
        List<PersonajeDto> dtos = service.getPersonajesByName(name);
        return dtos;
    }

}
