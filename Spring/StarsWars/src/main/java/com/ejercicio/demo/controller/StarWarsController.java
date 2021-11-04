package com.ejercicio.demo.controller;

import com.ejercicio.demo.dto.CharacterDTO;
import com.ejercicio.demo.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {

    IStarWarsService starWarsService;

    //Inyeccion de dependencias - puedo usar tambien @Autowired y no tenes construtor
    public StarWarsController(IStarWarsService starWarsService){
        this.starWarsService = starWarsService;
    }

    @GetMapping("/character/{name}")
    public ResponseEntity<List<CharacterDTO>> getInfoCharacter(@PathVariable String name){

        return new ResponseEntity<>(starWarsService.getCharacterService(name), HttpStatus.OK);

    }

}
