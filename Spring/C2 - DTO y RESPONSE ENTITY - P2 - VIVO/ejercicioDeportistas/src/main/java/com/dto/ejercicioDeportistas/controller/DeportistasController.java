package com.dto.ejercicioDeportistas.controller;

import com.dto.ejercicioDeportistas.Deporte;
import com.dto.ejercicioDeportistas.Persona;
import com.dto.ejercicioDeportistas.dto.DeporteDTO;
import com.dto.ejercicioDeportistas.dto.PersonaDeporteDTO;
import com.dto.ejercicioDeportistas.service.DeportesPersonasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportistasController {

    private DeportesPersonasService deportesPersonasService = new DeportesPersonasService();

    @GetMapping("findSports")
    public List<DeporteDTO> findSports(){
        return this.deportesPersonasService.getAllDeportes();
    }

    @GetMapping("findSports/{name}")
    public ResponseEntity<?> findSportsByName(@PathVariable String name){
        DeporteDTO deporteDTO = this.deportesPersonasService.findSportByName(name);
        if (deporteDTO.getNombre() != null) {
            return new ResponseEntity<>(deporteDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Deporte "+name+" no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> findSportsPersons(){
        return new ResponseEntity<>(this.deportesPersonasService.getDeportistas(), HttpStatus.OK);
    }
}
