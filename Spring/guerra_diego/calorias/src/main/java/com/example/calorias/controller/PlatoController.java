package com.example.calorias.controller;

import com.example.calorias.dto.PlatoDto;
import com.example.calorias.service.IPlatoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plato")
public class PlatoController {

    IPlatoService platoService;

    public PlatoController(IPlatoService platoService) {
        this.platoService = platoService;
    }

    @PostMapping("calorias")
    public String calorias (@RequestBody PlatoDto plato){

        double calorias = platoService.calcularCalorias(plato);
        System.out.println("CCC "+plato.getIngredientes());
        return "Las calorias del plato " + plato.getNombre() + "son: "+calorias;
    }

}
