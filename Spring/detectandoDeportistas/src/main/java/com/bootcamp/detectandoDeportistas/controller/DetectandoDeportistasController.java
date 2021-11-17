package com.bootcamp.detectandoDeportistas.controller;

import com.bootcamp.detectandoDeportistas.model.Deporte;
import com.bootcamp.detectandoDeportistas.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DetectandoDeportistasController {
    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    @PostMapping("/person")
    public ResponseEntity<String> createPerson(@RequestBody List<Persona> personBody) {
        personas = personBody;

        return new ResponseEntity("Usuarios Creados", HttpStatus.OK);
    }

    @PostMapping("/sport")
    public ResponseEntity<String> createSport(@RequestBody List<Deporte> sportBody) {
        deportes = sportBody;

        return new ResponseEntity("Deportes Creados", HttpStatus.OK);
    }
}