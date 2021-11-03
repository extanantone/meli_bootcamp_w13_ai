package com.example.spring.Deporte.controllers;

import com.example.spring.Deporte.FakeBD;
import com.example.spring.Deporte.dto.DeporteDTO;
import com.example.spring.Deporte.dto.DeportesDTO;
import com.example.spring.Deporte.dto.PersonaDeporteDTO;
import com.example.spring.Deporte.models.Deporte;
import com.example.spring.Deporte.models.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GestorDeporteController {


    @GetMapping("/findSports")
    public List<DeportesDTO> mostrarDeportes(){

        List<DeportesDTO> respuestaDTO = new ArrayList<>();

        for (Deporte d: FakeBD.deportesDisponibles) {

            DeportesDTO deporteDTO = new DeportesDTO();
            deporteDTO.setNivel(d.getNivel());
            deporteDTO.setNombre(d.getNombre());
            respuestaDTO.add(deporteDTO);

        }

        return respuestaDTO;

    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findSport(@PathVariable("name") String name){

        DeporteDTO res = new DeporteDTO();

        for (Deporte d: FakeBD.deportesDisponibles) {

            if(d.getNombre().equals(name)) {
                res.setNivel(d.getNivel());
                return new ResponseEntity<DeporteDTO>(res, HttpStatus.OK);
            }

        }

        res = null;
        return new ResponseEntity<DeporteDTO>(res, HttpStatus.BAD_REQUEST);


    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> mostrarAtletas(){

        List<PersonaDeporteDTO> respuestaDTO = new ArrayList<>();

        for (Persona p: FakeBD.atletas) {

            PersonaDeporteDTO personaAtleta = new PersonaDeporteDTO();
            personaAtleta.setPersonaNombre(p.getNombre());
            personaAtleta.setPersonaApellido(p.getApellido());
            personaAtleta.setDeporteNombre(p.getDeporte());

            respuestaDTO.add(personaAtleta);


        }

        return new ResponseEntity<>(respuestaDTO, HttpStatus.OK);

    }


}
