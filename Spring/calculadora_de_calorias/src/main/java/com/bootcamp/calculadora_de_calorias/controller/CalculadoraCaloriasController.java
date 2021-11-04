package com.bootcamp.calculadora_de_calorias.controller;

import com.bootcamp.calculadora_de_calorias.dto.InfoCaloriasDTO;
import com.bootcamp.calculadora_de_calorias.dto.PlatoDTO;
import com.bootcamp.calculadora_de_calorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/restaurante")
public class CalculadoraCaloriasController {

    private IPlatoService platoService;

    @Autowired
    public CalculadoraCaloriasController(IPlatoService platoService) {
        this.platoService = platoService;
    }

   /* @PostMapping("/calculadoracalorias")
    public ResponseEntity<?> getCalorias(@RequestBody PlatoDTO plato){
        InfoCaloriasDTO infoCalorias = new InfoCaloriasDTO();

        infoCalorias.setNombre(plato.getNombre());
        infoCalorias.setCantTotalCalorias(platoService.calcularCalorias(plato.getIngredientes()));
        infoCalorias.setIngredienteConMasCalorias(platoService.getIngredienteMaxCalorias(plato.getIngredientes()));
        infoCalorias.setIngredientes(platoService.getIngredientesAndCalorias(plato.getIngredientes()));

        return new ResponseEntity<>(infoCalorias, HttpStatus.OK);
    }*/

    @PostMapping("/calculadoracalorias")
    public ResponseEntity<List<InfoCaloriasDTO>> getCalorias(@RequestBody List<PlatoDTO> listaPlatos){
        List<InfoCaloriasDTO> listaInfoCalorias = new ArrayList<>();

        for (PlatoDTO plato : listaPlatos) {
            InfoCaloriasDTO infoCalorias = new InfoCaloriasDTO();

            infoCalorias.setNombre(plato.getNombre());
            infoCalorias.setCantTotalCalorias(platoService.calcularCalorias(plato.getIngredientes()));
            infoCalorias.setIngredienteConMasCalorias(platoService.getIngredienteMaxCalorias(plato.getIngredientes()));
            infoCalorias.setIngredientes(platoService.getIngredientesAndCalorias(plato.getIngredientes()));

            listaInfoCalorias.add(infoCalorias);
        }

        return new ResponseEntity<>(listaInfoCalorias, HttpStatus.OK);
    }


}
