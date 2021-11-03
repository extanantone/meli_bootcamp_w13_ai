package com.example.deportes.controller;

import DTO.DTOPersona;
import com.example.deportes.model.Deporte;
import com.example.deportes.service.methodsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controllerEjercicio {
    methodsService servicio = new methodsService();
    @GetMapping(path="/findSports")
    public ResponseEntity<List<Deporte>> devolverDeportes(){
        List<Deporte> dep= servicio.devolverDeportes();
        return new ResponseEntity(dep, HttpStatus.OK);
    }
    @GetMapping(path="/findSports/{name}")
    public ResponseEntity<String> buscarDeporte(@PathVariable("name") String nombre){
        String nivel = servicio.buscarDeporte(nombre);
        return new ResponseEntity(nivel, HttpStatus.OK);
    }
    @GetMapping(path="/findSportsPersons")
    public ResponseEntity<DTOPersona> getDto1(){
        return new ResponseEntity(servicio.getDto1(), HttpStatus.OK);
    }

}
