package com.MeliBoot.StarWars.controllers;

import com.MeliBoot.StarWars.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonajeController {

    //@Autowired  --> inyeccion de dependencias
    PersonajeService personajeService;
    //Inyeccion de Dependencias
    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/personajes")
    public ResponseEntity<?> getPersonajePorNombre(){
        return personajeService.getPersonajes();
    }

    @GetMapping("/personaje/{nombre}")
    public ResponseEntity<?> getPersonajePorNombre(@PathVariable ("nombre") String nombre){
        return personajeService.getPersonajePorNombre(nombre);
    }
}
