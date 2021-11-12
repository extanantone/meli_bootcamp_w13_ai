package com.DTO.DTO.controller;

import com.DTO.DTO.entity.Deporte;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;

@RestController
public class DTOController {

    public static final ArrayList<Deporte> deportes = new ArrayList<>();


    @GetMapping("/findSports")
    ResponseEntity<Deporte> findSport(){
        initDeportes();

        return ResponseEntity.ok(deportes.stream().forEach(d -> String.format("nombre" + d.getNombre())));
    }

    static void initDeportes(){

        deportes.add(new Deporte("Futbol", "Profesional"));
        deportes.add(new Deporte("Natación", "principiante"));




    }
}
