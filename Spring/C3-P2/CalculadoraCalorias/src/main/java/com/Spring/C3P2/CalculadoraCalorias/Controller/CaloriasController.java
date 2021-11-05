package com.Spring.C3P2.CalculadoraCalorias.Controller;

import com.Spring.C3P2.CalculadoraCalorias.DTO.PlatoDTO;
import com.Spring.C3P2.CalculadoraCalorias.Service.IPlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaloriasController {

    IPlatoService platoService;

    public CaloriasController(IPlatoService platoService) {
        this.platoService = platoService;
    }

    @PostMapping("/totalCalorias")
    public ResponseEntity<String> totalCalorias (@RequestBody PlatoDTO plato) {
        int calorias = platoService.obtenerCalorias(plato);

        return new ResponseEntity<>(
                "Este plato tiene: " + calorias + " calorías",
                HttpStatus.OK);
    }







    @PostMapping("/prueba")
    public PlatoDTO totalCalorias2 (@RequestBody PlatoDTO plato) {
        return plato;
    }
}
