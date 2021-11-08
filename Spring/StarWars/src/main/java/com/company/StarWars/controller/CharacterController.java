package com.company.StarWars.controller;

import com.company.StarWars.dto.CharacterDTO;
import com.company.StarWars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/character/")
public class CharacterController {

     @Autowired
     CharacterService service;

     @GetMapping("/{name}")
     public ResponseEntity<List<CharacterDTO>> getCharacterByName(@PathVariable String name) {
              return ResponseEntity.ok(this.service.getCharactersByName(name));
     }
}
