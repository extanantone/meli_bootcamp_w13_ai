package com.example.plato.constructor;

import com.example.plato.dto.PlatoDTO;
import com.example.plato.model.Plato;
import com.example.plato.service.ICaloriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloriesConstructor {

    @Autowired
    ICaloriesService caloriesService;

    @GetMapping()
    public ResponseEntity<PlatoDTO> getCalories(@RequestBody Plato platoC) {

        return new ResponseEntity<PlatoDTO>(caloriesService.getCalorias(platoC), HttpStatus.OK);
    }
}
