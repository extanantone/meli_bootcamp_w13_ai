package com.example.springii_2.controller;


import com.example.springii_2.dto.SportDTO;
import com.example.springii_2.dto.SportPersonDTO;
import com.example.springii_2.models.DataBase;
import com.example.springii_2.models.Person;
import com.example.springii_2.models.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FindSportController {

    private DataBase listas = new DataBase();

    @PostMapping("/person")
    public ResponseEntity<String> createPerson(@RequestBody List<Person> personBody) {
        listas.setPersons(personBody);
        return new ResponseEntity("usuarios creados", HttpStatus.OK);
    }

    @PostMapping("/sport")
    public ResponseEntity<String> createSport(@RequestBody List<Sport> sportBody) {

        listas.setSports(sportBody);
        return new ResponseEntity("deportes creados", HttpStatus.OK);
    }

    @GetMapping("/findSports")
    public List<Sport> findSports () {

        return listas.getSports() ;
    }

    @GetMapping("/findSport/{id}")
    public ResponseEntity<SportDTO> findSport (@PathVariable Integer id) {

        SportDTO sportDto = new SportDTO();

        Sport sport = listas.getSports().stream().filter(x -> x.getId() == id).findFirst().get();

        sportDto.setName(sport.getName());
        sportDto.setNivel(sport.getNivel());

        return new ResponseEntity<SportDTO>(sportDto,HttpStatus.OK);
    }

    @GetMapping("/findSportsPerson")
    public ResponseEntity<List<SportPersonDTO>> findSportsPerson() {
        List<SportPersonDTO> result = new ArrayList<>();

        List<Person> personas = listas.getPersons();

        for (Person p: personas
             ) {

            SportPersonDTO sportPersonDTO = new SportPersonDTO();
            sportPersonDTO.setFullName(p.getName() + " " + p.getLastName());
            Sport sport = listas.getSports().stream().filter(x -> x.getId() == p.getSportId()).findFirst().get();
            sportPersonDTO.setNameSport(sport.getName());


            result.add(sportPersonDTO);
        }

        return new ResponseEntity(result,HttpStatus.OK);
    }

}
