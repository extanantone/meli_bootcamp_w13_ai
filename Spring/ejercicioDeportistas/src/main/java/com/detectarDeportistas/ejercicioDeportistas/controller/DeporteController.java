package com.detectarDeportistas.ejercicioDeportistas.controller;
import com.detectarDeportistas.ejercicioDeportistas.model.Deporte;
import com.detectarDeportistas.ejercicioDeportistas.service.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class DeporteController {
    DeporteService deporteService = new DeporteService();
    @GetMapping("/findSports")
    public ResponseEntity<?> findSports(){
        return new ResponseEntity(deporteService.getDeportes(), HttpStatus.OK);
    }
    @GetMapping("/findSport/{deporte}")
    public ResponseEntity<?> findSport(@PathVariable String deporte){
        return new ResponseEntity(deporteService.buscarDeporte(deporte),HttpStatus.OK);
    }
}
