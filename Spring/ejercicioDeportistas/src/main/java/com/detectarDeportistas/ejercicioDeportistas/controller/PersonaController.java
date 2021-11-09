package com.detectarDeportistas.ejercicioDeportistas.controller;
import com.detectarDeportistas.ejercicioDeportistas.dto.DeportistaDTO;
import com.detectarDeportistas.ejercicioDeportistas.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class PersonaController {
    PersonaService personaService = new PersonaService();
    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> mostrarDeportistas(){
        return new ResponseEntity(personaService.buscarDeportistas(), HttpStatus.OK);
    }
}
