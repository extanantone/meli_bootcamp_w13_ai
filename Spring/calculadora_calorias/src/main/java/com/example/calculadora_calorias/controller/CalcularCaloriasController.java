package com.example.calculadora_calorias.controller;

import com.example.calculadora_calorias.dto.PlatoDTO;
import com.example.calculadora_calorias.services.CalcularCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularCaloriasController {
    @Autowired
    CalcularCaloriasService calcularCaloriasService;

    @PostMapping("/plato/cantidadCalorias")
    public ResponseEntity<Integer> calcularCalorias (PlatoDTO plato){

        return new ResponseEntity<Integer>(calcularCaloriasService.calcularCalorias(plato.getIngredients()), HttpStatus.OK);
    }
}
