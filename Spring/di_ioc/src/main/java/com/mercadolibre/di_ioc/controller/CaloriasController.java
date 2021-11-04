package com.mercadolibre.di_ioc.controller;

import com.mercadolibre.di_ioc.dto.IngredientesPlatoDTO;
import com.mercadolibre.di_ioc.dto.PlatoCaloriasDTO;
import com.mercadolibre.di_ioc.model.Ingrediente;
import com.mercadolibre.di_ioc.model.IngredientesReceta;
import com.mercadolibre.di_ioc.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calorias")
public class CaloriasController {
    @Autowired
    PlatoService mPlatoService;

    @PostMapping("/plato")
    private ResponseEntity<List<PlatoCaloriasDTO>> postIngredientes(@RequestBody IngredientesPlatoDTO[] mIngredientesPlato){
        return new ResponseEntity<>(mPlatoService.totalCalorias(mIngredientesPlato), HttpStatus.OK);
    }

}