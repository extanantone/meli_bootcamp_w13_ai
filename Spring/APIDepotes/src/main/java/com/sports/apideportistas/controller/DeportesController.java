package com.sports.apideportistas.controller;

import com.sports.apideportistas.dto.DeporteDTO;
import com.sports.apideportistas.dto.DeportistaDTO;
import com.sports.apideportistas.service.DeportistasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/deportes")
public class DeportesController {

    DeportistasService service = new DeportistasService();

    @GetMapping(path = "/findSports")
    public ResponseEntity<?> findSports(){

        List<DeporteDTO> sports = service.findSports();

        return (sports.isEmpty())? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se han encontrado Deportes")
                 : ResponseEntity.ok(sports);
    }

    @GetMapping(path = "/findSport/{nombreDeporte}")
    public ResponseEntity<?> findSport(@PathVariable String nombreDeporte){

        DeporteDTO d = service.findSport(nombreDeporte);

        return (d == null) ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deporte no encontrado")
                : ResponseEntity.ok().body(d);
    }

    @GetMapping(path = "/findSportsPersons")
    public ResponseEntity<?> findSportsPersons(){

        List<DeportistaDTO> sports = service.findSportsPersons();

        return (sports.isEmpty())? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se han encontrado deportistas")
                : ResponseEntity.ok(sports);
    }




}
