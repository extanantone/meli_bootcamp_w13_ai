package com.example.demo.controller;

import com.example.demo.dto.PersonaDeporteDTO;
import com.example.demo.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    PersonaService ps = new PersonaService();
    //Ejercicio 3
    @GetMapping("/findSportPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> buscarPersonasDeportes() {
        ps.inicializarPersonas();
        return ps.buscarPersonasDeportistas();

    }
}
