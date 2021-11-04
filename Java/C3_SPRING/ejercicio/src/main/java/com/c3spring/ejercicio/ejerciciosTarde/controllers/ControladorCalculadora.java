package com.c3spring.ejercicio.ejerciciosTarde.controllers;

import com.c3spring.ejercicio.ejerciciosTarde.dto.PlatoInDTO;
import com.c3spring.ejercicio.ejerciciosTarde.dto.PlatoOutDTO;
import com.c3spring.ejercicio.ejerciciosTarde.service.CalculadoraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculadora")
public class ControladorCalculadora {

    @Autowired
    private CalculadoraServicio platosServicio;

    @GetMapping("/")
    public String saludo()
    {
        return "si funciona la calculadora!";
    }


    @PostMapping("/plato")
    public ResponseEntity<PlatoOutDTO> calcularPlato(@RequestBody PlatoInDTO platoIn)
    {
        return new  ResponseEntity<>(platosServicio.calcularDatos(platoIn), HttpStatus.OK);
    }

    @PostMapping("/listaplatos")
    public ResponseEntity<List<PlatoOutDTO>> calcularPlato(@RequestBody List<PlatoInDTO> platoIn)
    {
        return new  ResponseEntity<>(platosServicio.calcularDatosMasivo(platoIn), HttpStatus.OK);
    }

}
