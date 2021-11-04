package com.example.calorias.controller;

import com.example.calorias.dto.platoDto;
import com.example.calorias.service.ICaloriasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CaloriasController {
    ICaloriasService servicio;

    public CaloriasController(ICaloriasService servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/totalCalorias")
    public ResponseEntity<String> cantidadCaloriasPlato(@RequestBody platoDto plato){
        int x=servicio.obtenerCalorias(plato);
        return new ResponseEntity<>("Este plato tiene "+ x +" calorias", HttpStatus.OK);
    }
}
