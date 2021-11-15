package com.company.recipes.controller;

import com.company.recipes.dto.PlatoDTO;
import com.company.recipes.service.PlatoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/plato")
public class FoodController {

    Logger logger = LoggerFactory.getLogger(FoodController.class);

    PlatoService platoService;

    public FoodController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @PostMapping("/calorias")
    @ResponseBody
    public ResponseEntity<Integer> getCalorias(
            @RequestBody PlatoDTO plato
    ) {
        logger.info("Plato enviado: "+plato.toString());
        return ResponseEntity.ok(this.platoService.getCalorias(plato));
       }
}
