package com.bootcamp.Deportistas.controller;

import com.bootcamp.Deportistas.BaseDeDatos;
import com.bootcamp.Deportistas.DTO.DeporteDTO;
import com.bootcamp.Deportistas.model.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class deportistaController {

    @GetMapping("/findSports")
    public List<DeporteDTO> Deportes(){
        List<DeporteDTO> list = new ArrayList<DeporteDTO>();
        for (Deporte d: BaseDeDatos.deporte) {
            DeporteDTO dto = new DeporteDTO();
            dto.setNombre(d.getNombre());
            dto.setNivel(d.getNivel());
            list.add(dto);
        }
        return list;
    }

    @GetMapping("/findSport")
    ResponseEntity<Deporte> getNomDepor(@RequestBody Deporte deporteDTO){

        for (Deporte d: BaseDeDatos.deporte) {
            if(d.getNombre().equals(deporteDTO.getNombre())){
                d.getNombre();
                d.getNivel();
                return new ResponseEntity(d, HttpStatus.OK);
            }
        }
        String aux=deporteDTO.getNombre();
        deporteDTO.setNombre(aux+" no existe!");
        return new ResponseEntity(deporteDTO, HttpStatus.BAD_REQUEST);
    }

}
