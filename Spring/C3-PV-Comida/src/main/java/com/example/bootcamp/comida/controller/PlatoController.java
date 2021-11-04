package com.example.bootcamp.comida.controller;

import com.example.bootcamp.comida.dto.PlatoDTO;
import com.example.bootcamp.comida.model.Ingrediente;
import com.example.bootcamp.comida.model.Plato;
import com.example.bootcamp.comida.repository.IIngredienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlatoController {


    private IIngredienteRepository ingredienteRepository;

    public PlatoController(IIngredienteRepository ingredienteRepository){
        this.ingredienteRepository = ingredienteRepository;
    }

    @GetMapping("/ingredientes")
    public List<Ingrediente> traerIngredientes(){

        return ingredienteRepository.traerIngredientes();

    }


    @PostMapping("/menu/save")
    public ResponseEntity<String> guardarPlato(@RequestBody PlatoDTO p){




        return new ResponseEntity<>("Todo ok",HttpStatus.OK);

    }



}
