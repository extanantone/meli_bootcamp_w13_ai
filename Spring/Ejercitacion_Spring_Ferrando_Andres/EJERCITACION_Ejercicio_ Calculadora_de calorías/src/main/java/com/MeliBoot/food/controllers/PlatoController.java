package com.MeliBoot.food.controllers;

import com.MeliBoot.food.models.Plato;
import com.MeliBoot.food.services.PlatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlatoController {

    PlatoService platoService;

    public PlatoController(PlatoService platoService){
        this.platoService = platoService;
    }

    @PostMapping("/calculo")
    public int calCaloria(@RequestBody Plato plato){
        return platoService.calculo(plato);
    }

  /*  @GetMapping("/{plato}")
    public List<Plato> getPlatos(@PathVariable("plato") String plato
            //, @PathVariable("peso") int peso
    ){
        return platoService.getPlatos(plato);
    }*/
}
