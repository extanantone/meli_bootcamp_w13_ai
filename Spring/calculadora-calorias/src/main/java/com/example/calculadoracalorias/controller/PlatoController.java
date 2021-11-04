package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.entity.Plato;
import com.example.calculadoracalorias.service.PlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {

    private final PlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @PostMapping()
    public ResponseEntity<Plato> crear(@RequestBody Plato nuevoPlato) {
        Plato plato = platoService.guardarPlato(nuevoPlato);
        if (plato == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(plato, HttpStatus.CREATED);
    }

    @GetMapping("/plato")
    public String getDetallesPlato(@RequestParam String nombre) {
        Plato plato = platoService.obtenerPlato(nombre);
        if (plato == null) return "\nNo se encontro un plato con el nombre: " + nombre;
        return platoService.mostrarDetallesPlato(plato);
    }

    @GetMapping
    public String getDetallesPlatos(@RequestBody List<String> nombres) {
        List<Plato> platos = platoService.obtenerPlatos(nombres);
        return platoService.mostrarDetallesPlatos(platos);
    }
}

