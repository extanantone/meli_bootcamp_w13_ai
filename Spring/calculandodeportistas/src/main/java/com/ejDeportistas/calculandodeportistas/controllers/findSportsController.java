package com.ejDeportistas.calculandodeportistas.controllers;


import com.ejDeportistas.calculandodeportistas.dtos.PersonaDeporteDto;
import com.ejDeportistas.calculandodeportistas.dtos.sportsNameDto;
import com.ejDeportistas.calculandodeportistas.models.Deporte;
import com.ejDeportistas.calculandodeportistas.services.Db;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@RestController
public class findSportsController {
    Db listas = new Db();
    @GetMapping("/test")
    public String testing(){
        return "Hi World";
    }
    @GetMapping("/findSports")
    public ResponseEntity<sportsNameDto> sportsNames(){
        sportsNameDto dto = new sportsNameDto(listas.getListaDeporte());
        return new ResponseEntity<>(dto , HttpStatus.OK );
    }
    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> findSports(@PathVariable("name") String name){
        Deporte d = listas.searchDeporte(name);
        if(d != null){return new ResponseEntity<>(d.getNombre() + " nivel: " + d.getNivel(), HttpStatus.OK );}
        return new ResponseEntity<>("No se ha encontrado el deporte" , HttpStatus.NOT_FOUND );
    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List> allPersonsWithSportName(){
        return new ResponseEntity<>(listas.goRelationToDto() , HttpStatus.OK );
    }
}
