package com.MeliBoot.food.controllers;

import com.MeliBoot.food.models.Plato;
import com.MeliBoot.food.services.PlatoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlatoController {

    PlatoService platoService;

    public PlatoController(PlatoService platoService){
        this.platoService = platoService;
    }

    @GetMapping("/{plato}")
    public List<Plato> getPlatos(@PathVariable("plato") String plato
            //, @PathVariable("peso") int peso
    ){
        return platoService.getPlatos(plato);
    }
}
