package com.IOyDI.calculadoraCalorias.controller;

import com.IOyDI.calculadoraCalorias.dto.IngredienteDTO;
import com.IOyDI.calculadoraCalorias.dto.PlatoDTO;
import com.IOyDI.calculadoraCalorias.service.IIngredienteService;
import com.IOyDI.calculadoraCalorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    IIngredienteService ingredienteService;
    IPlatoService platoService;

    public MenuController(IIngredienteService ingredienteService, IPlatoService platoService) {
        this.ingredienteService = ingredienteService;
        this.platoService = platoService;
    }

    @PostMapping("/getCalorias")
    public ResponseEntity<String> getCalorias(@RequestBody PlatoDTO plato) {
        Double calorias = platoService.getCalorias(plato);
        return new ResponseEntity<>("Este plato tiene "+calorias+" calorias", HttpStatus.OK);
    }

    @PostMapping("/getIngredientes")
    public ResponseEntity<?> getIngredientes(@RequestBody PlatoDTO plato) {
        List<IngredienteDTO> ingredienteDTOS = platoService.getIngredientes(plato);
        return new ResponseEntity<>(ingredienteDTOS, HttpStatus.OK);
    }

    @PostMapping("/getIngredienteMasCalorias")
    public ResponseEntity<?> getIngredienteMasCalorias(@RequestBody PlatoDTO plato) {
        IngredienteDTO ingredienteDTO = platoService.getIngredienteMasCalorias(plato);
        return new ResponseEntity<>(ingredienteDTO, HttpStatus.OK);
    }
}
