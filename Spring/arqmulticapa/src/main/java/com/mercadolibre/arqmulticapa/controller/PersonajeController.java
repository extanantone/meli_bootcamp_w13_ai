package com.mercadolibre.arqmulticapa.controller;

import com.mercadolibre.arqmulticapa.dto.PersonajeDTO;
import com.mercadolibre.arqmulticapa.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeController {
    //@Autowired
    IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService){
        this.personajeService= personajeService;
    }

    @GetMapping("/{nombre}")
    private ResponseEntity<List<PersonajeDTO>> getPersonaje(@PathVariable String nombre){
        return new ResponseEntity<>(personajeService.obtenerPersonaje(nombre), HttpStatus.OK);
    }
}
