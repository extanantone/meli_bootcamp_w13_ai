package com.c3.p2.controller;

import com.c3.p2.dto.CaloriasDto;
import com.c3.p2.dto.PlatoDto;
import com.c3.p2.service.ICaloriasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IndexController {

    ICaloriasService caloriasService;

    public IndexController(ICaloriasService caloriasService){
        this.caloriasService = caloriasService;
    }

    @PostMapping("/plato")
    public ResponseEntity<CaloriasDto> caloriasPlato(@RequestBody PlatoDto plato){

        return new ResponseEntity<>(caloriasService.calcularCaloriasPlato(plato), HttpStatus.OK);
    }

    @PostMapping("/platos")
    public ResponseEntity<List<CaloriasDto>> caloriasPlato(@RequestBody List<PlatoDto> platosList){

        return new ResponseEntity<>(caloriasService.calcularCaloriasListaPlatos(platosList), HttpStatus.OK);
    }
}
