package com.example.bootcamp.StarWarsApi.controller;

import com.example.bootcamp.StarWarsApi.dto.PersonajeDTO;
import com.example.bootcamp.StarWarsApi.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeController {

    //Inversion de control: el framework llama a los services que hicimos, controllers etc.
    //Inversion de dependencia: Spring me indica de que depende mi controller o clase
    IPersonajeService personajeService;

    public PersonajeController (IPersonajeService personajeService){
        this.personajeService = personajeService;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(@PathVariable("nombre") String nombre){



        return new ResponseEntity<>(personajeService.obtenerPersonajes(nombre), HttpStatus.OK);

    }



}
