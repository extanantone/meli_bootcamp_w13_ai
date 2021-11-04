package com.bootcamp.StarWars.Controller;

import com.bootcamp.StarWars.DTO.PersonajeDTO;
import com.bootcamp.StarWars.Model.Personaje;
import com.bootcamp.StarWars.Service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeController {

    @Autowired
    IPersonajeService personajeService;

    @GetMapping()
    public ResponseEntity<List<PersonajeDTO>> getPersonaje (@RequestBody Personaje personaje){
        return new ResponseEntity(personajeService.obtenerPersonaje(personaje.getName()), HttpStatus.OK);
    }
}
