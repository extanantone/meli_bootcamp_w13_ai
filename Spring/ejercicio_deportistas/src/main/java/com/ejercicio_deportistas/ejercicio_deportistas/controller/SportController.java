package com.ejercicio_deportistas.ejercicio_deportistas.controller;

import com.ejercicio_deportistas.ejercicio_deportistas.dto.SportDTO;
import com.ejercicio_deportistas.ejercicio_deportistas.model.Sport;
import com.ejercicio_deportistas.ejercicio_deportistas.services.MainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {

    @GetMapping("/findSports")
    public List<Sport> findSports(){
        MainService service=new MainService();
        return service.getSportList();
    }

    @GetMapping("/findSport/{name}")
    ResponseEntity<SportDTO> specificSport(@PathVariable String name){
        MainService service=new MainService();
        SportDTO sportDTO=new SportDTO();
        sportDTO.setLevel(service.levelSport(name));
        if(sportDTO.getLevel()!=""){
            return new ResponseEntity<>(sportDTO,HttpStatus.OK);
        }else{
            return new ResponseEntity<SportDTO>(sportDTO,HttpStatus.BAD_REQUEST);
        }

    }

}
