package com.bootcamp.calorias.controller;

import com.bootcamp.calorias.dto.DTOCalories;
import com.bootcamp.calorias.dto.DTOPlato;
import com.bootcamp.calorias.service.ICaloriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaloriesController {

    ICaloriesService service;

    public CaloriesController(ICaloriesService service) {
        this.service = service;
    }

    @PostMapping("/calories")
    public ResponseEntity<List<DTOCalories>> getCalories(@RequestBody List<DTOPlato> platos){
        ResponseEntity respuesta = new ResponseEntity(service.getCalories(platos), HttpStatus.OK);
        return respuesta;
    }
}
