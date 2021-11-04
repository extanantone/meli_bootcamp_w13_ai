package com.springIII.maniana.controller;

import com.springIII.maniana.dto.PersonajeDTO;
import com.springIII.maniana.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeController {


    IPersonajeService personajesService;

    public PersonajeController(IPersonajeService personajesService) {
        this.personajesService = personajesService;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(
            @PathVariable String nombre){
        return new ResponseEntity<>(
                personajesService.obtenerPersonajes(nombre),
                HttpStatus.OK) ;
    }

}
