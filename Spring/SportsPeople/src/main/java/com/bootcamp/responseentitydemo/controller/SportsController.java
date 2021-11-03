package com.bootcamp.responseentitydemo.controller;

import com.bootcamp.responseentitydemo.dto.PersonDTO;
import com.bootcamp.responseentitydemo.entity.Sport;
import com.bootcamp.responseentitydemo.service.PeopleService;
import com.bootcamp.responseentitydemo.service.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportsController {

    SportService SPORTSERVICE = new SportService();
    PeopleService PEOPLESERVICE = new PeopleService();

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findSports() {
        List<Sport> resBody = SPORTSERVICE.getAllSports();
        return new ResponseEntity<>(resBody, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Sport> findSportByName(@PathVariable String name) {
        Sport resBody = SPORTSERVICE.getSportByName(name);
        return new ResponseEntity<>(resBody, HttpStatus.OK);
    }

    @GetMapping("/findSportsPeople")
    public ResponseEntity<List<PersonDTO>> findSportsPeople() {
        List<PersonDTO> resBody = PEOPLESERVICE.getAllPeople();
        return new ResponseEntity<>(resBody, HttpStatus.OK);
    }
}
