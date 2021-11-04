package com.c2.p2vivo.controllers;

import com.c2.p2vivo.dtos.DeportistasDto;
import com.c2.p2vivo.models.Deporte;
import com.c2.p2vivo.services.queryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class homeController {

    queryService service;

    public homeController(){
        service = new queryService();
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte> > verDeportes(){
        List<Deporte> deporteList = service.getDeportesList();
        return new ResponseEntity<>(deporteList, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> consultarNivelDeporte(@PathVariable String name){
        String nivel = service.getNivelDeporte(name);
        if (nivel != null){
            return new ResponseEntity<>(nivel, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistasDto> > consultarDeportistas(){
        List<DeportistasDto> deportistasDtoList = new ArrayList<>();
        service.getDeportistas().forEach(p -> deportistasDtoList.add(new DeportistasDto(p.getNombre(), p.getApellido(), p.getDeporte().getNombre())));
        if(deportistasDtoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(deportistasDtoList, HttpStatus.OK);
    }
}
