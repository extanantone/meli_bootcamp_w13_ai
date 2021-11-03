package com.example.deportistas.demo.controller;

import com.example.deportistas.demo.BaseDeDatos;
import com.example.deportistas.demo.DTO.DeportesDTO;
import com.example.deportistas.demo.models.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class controller {

    @GetMapping("/findSports")
    public List<DeportesDTO> Deportes(){
        List<DeportesDTO> list = new ArrayList<DeportesDTO>();
        for (Deporte d: BaseDeDatos.deporte){
            DeportesDTO dto = new DeportesDTO();
            dto.setName(d.getDeporte());
            dto.setNivel(d.getNivel());
            list.add(dto);

        }
        return list;

    }
    @GetMapping("/findSport")
    ResponseEntity<Deporte> getNomDepor(@RequestBody Deporte deporteDTO){
        for (Deporte d:
             BaseDeDatos.deporte) {
            if(d.getDeporte().equals(deporteDTO.getDeporte())){
                d.getDeporte();
                d.getNivel();
                return new ResponseEntity(d, HttpStatus.OK);
            }

        }
        return new ResponseEntity("hola", HttpStatus.OK);

    }
    @GetMapping("/findSportPersona")
        public void SportPersona(){

    }
}
