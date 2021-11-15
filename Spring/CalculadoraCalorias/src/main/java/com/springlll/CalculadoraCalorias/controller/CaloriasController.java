package com.springlll.CalculadoraCalorias.controller;


import com.springlll.CalculadoraCalorias.dto.PlatoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/calcularCalorias")
public class CaloriasController {

    @PostMapping("/")
    public ResponseEntity<List<PlatoDTO>> getDatosPlato(@RequestBody PlatoDTO plato){
        return new ResponseEntity<>(
                ,
                HttpStatus.OK) ;
    }
}
