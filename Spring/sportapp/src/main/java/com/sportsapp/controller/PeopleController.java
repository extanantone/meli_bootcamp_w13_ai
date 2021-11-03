package com.sportsapp.controller;

import com.sportsapp.dto.DeportistDto;
import com.sportsapp.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> getSportPerson(){

        List<DeportistDto> dtos =peopleService.getPeoples().stream()
                .map(i->new DeportistDto(i.getName(),i.getLastName(),i.getSport().getName()))
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

}
