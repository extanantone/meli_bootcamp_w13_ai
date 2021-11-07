package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class CharacterController {

    ICharacterService characterService;

    public CharacterController(ICharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{letters}")
    public ResponseEntity<List<CharacterDTO>> characters(@PathVariable String letters) {
        return new ResponseEntity<>(characterService.getCharacters(letters), HttpStatus.OK);
    }
}
