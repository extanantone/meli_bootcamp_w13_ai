package com.bootcamp.calculadorDeCalorias.controller;

import com.bootcamp.calculadorDeCalorias.dto.InfoPlatoDTO;
import com.bootcamp.calculadorDeCalorias.dto.PlatoDTO;
import com.bootcamp.calculadorDeCalorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calorias")
@Controller
public class CaloriasController {

    @Autowired
    IPlatoService PlatoService;



    @PostMapping("/calcularCalorias")
    public InfoPlatoDTO obtenerInfoPlato(@RequestBody PlatoDTO plato) {
        return null;
    }
}
