package com.C3P2VIVO.CalculadoraCalorias.controller;

import com.C3P2VIVO.CalculadoraCalorias.dto.PlatoCalculadoDTO;
import com.C3P2VIVO.CalculadoraCalorias.dto.PlatoDTO;
import com.C3P2VIVO.CalculadoraCalorias.service.PlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlatoController {

    private final PlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @PostMapping ("/plato")
    public ResponseEntity<PlatoCalculadoDTO> calcularCalorias(@RequestBody PlatoDTO platoDTO){
        System.out.println(platoDTO.getName());

        return new ResponseEntity<>(platoService.calcularCalories(platoDTO), HttpStatus.OK);
    }

    @PostMapping ("/platos")
    public ResponseEntity<List<PlatoCalculadoDTO>> calcularCaloriasPlatos(@RequestBody List<PlatoDTO> platosDTO){

        return new ResponseEntity<>(platoService.calcularCaloriesPlatos(platosDTO), HttpStatus.OK);
    }
}
