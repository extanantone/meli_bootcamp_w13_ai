package com.sportsapp.controller;

import com.sportsapp.dto.SportAndLevelDto;
import com.sportsapp.dto.SportDto;
import com.sportsapp.model.Sport;
import com.sportsapp.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportController {
    @Autowired
    private SportService sportService;

    @GetMapping("/findSports")
    public ResponseEntity<?> getAllSports(){
        return ResponseEntity.ok(sportService.getSports().stream().map(i->new SportAndLevelDto(i.getName(),i.getLevel())));
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> getSportByName(@PathVariable String name){
        Sport s = sportService.getSportByName(name);
        if(s==null)
            return ResponseEntity.notFound().build();
        SportDto dto = new SportDto();
        dto.setLevel(s.getLevel());
        return ResponseEntity.ok(dto);

    }
}
