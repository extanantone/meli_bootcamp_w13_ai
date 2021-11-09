package com.example.bootcamp.comida.controller;

import com.example.bootcamp.comida.dto.CaloriasTotalesDTO;
import com.example.bootcamp.comida.dto.IngredienteDTO;
import com.example.bootcamp.comida.dto.PlatoDTO;
import com.example.bootcamp.comida.dto.PlatoPesoDTO;
import com.example.bootcamp.comida.model.Ingrediente;
import com.example.bootcamp.comida.model.Plato;
import com.example.bootcamp.comida.repository.IIngredienteRepository;
import com.example.bootcamp.comida.service.IIngredienteService;
import com.example.bootcamp.comida.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlatoController {

   @Autowired
    private IPlatoService platoService;

   @Autowired
   private IIngredienteService ingredienteService;



    @GetMapping("/platos")
    public List<PlatoDTO> traerPlatos(){

        return platoService.obtenerPlatos();

    }


    @PostMapping("/menu/save")
    public ResponseEntity<String> guardarPlato(@RequestBody PlatoDTO p){

        platoService.crearPlato(p);
        return new ResponseEntity<>("Todo ok",HttpStatus.OK);

    }

    @GetMapping("/plato/calorias")
    public CaloriasTotalesDTO obtenerCaloriasIngresandoPlato(@RequestBody PlatoPesoDTO plato){

        CaloriasTotalesDTO ct = new CaloriasTotalesDTO();
        ct = platoService.obtenerCaloriasPorGramos(plato);

        return ct;
    }

    @GetMapping("/plato/listacalorias")
    public List<IngredienteDTO> obtenerIngredientesIngresandoPlato(@RequestBody PlatoDTO plato){

        List<IngredienteDTO> response = new ArrayList<>();

        response = platoService.obtenerIngredientesPorPlato(plato);

        return response;
    }


    @GetMapping("/plato/mayorCaloria")
    public IngredienteDTO obtenerIngredienteConMayorCaloria(@RequestBody PlatoDTO plato){

        IngredienteDTO response = new IngredienteDTO();

        response = platoService.obtenerIngredienteConMayorCaloria(plato);

        return response;
    }





}
