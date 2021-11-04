package com.bootcamp.apistarwars.controller;

import com.bootcamp.apistarwars.dto.PersonajeDTO;
import com.bootcamp.apistarwars.service.IPersonajeService;
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

    //@Autowired inyecta la dependencia
    @Autowired
    IPersonajeService personajeService;

    //inyeccion manual
/*    public PersonajeController(IPersonajeService personajeService) {
        this.personajeService = personajeService;
    }*/

    @GetMapping("/{nombre}")
    public ResponseEntity<?> getPersonaje(@PathVariable String nombre){

        List<PersonajeDTO> personajes = personajeService.obtenerPersonaje(nombre);

        return (personajes.isEmpty()) ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Personaje no encontrado") :
                ResponseEntity.ok().body(personajes);
    }

}
