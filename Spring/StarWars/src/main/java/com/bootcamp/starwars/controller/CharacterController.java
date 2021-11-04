package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.service.ICharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    ICharacterService characterService;

    public CharacterController(ICharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<CharacterDTO>> getCharactersByName(
            @RequestParam String name
    ) {
        List<CharacterDTO> resBody = this.characterService.getCharactersByName(name);
        return new ResponseEntity<>(
                resBody,
                HttpStatus.OK
        );
    }
}
