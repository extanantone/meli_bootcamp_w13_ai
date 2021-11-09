package com.bootcamp.C3P2EJ1.controller;

import com.bootcamp.C3P2EJ1.dto.IngredienteDTO;
import com.bootcamp.C3P2EJ1.dto.PlatoDTO;
import com.bootcamp.C3P2EJ1.service.IIngredienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IngredienteController {
    IIngredienteService iIngredienteService;

    public IngredienteController(IIngredienteService iIngredienteService) {
        this.iIngredienteService = iIngredienteService;
    }

    @PostMapping("/totalCalorias")
    public double obtenerTotalCalorias(@RequestBody PlatoDTO platoDTO) {
        return iIngredienteService.cantidadTotalCalorias(platoDTO);
    }

    @PostMapping("/listaIngredientes")
    public List<String> listaIngredientes(@RequestBody PlatoDTO platoDTO) {
        return iIngredienteService.obtenerListaIngredientes(platoDTO);
    }

    @PostMapping("/ingredienteMayorCaloria")
    public IngredienteDTO ingredienteMayorCaloria(@RequestBody PlatoDTO platoDTO) {
        return iIngredienteService.ingredienteMayorCaloria(platoDTO);
    }
}
