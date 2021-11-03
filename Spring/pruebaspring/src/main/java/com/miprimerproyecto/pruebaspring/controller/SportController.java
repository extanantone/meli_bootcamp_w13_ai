package com.miprimerproyecto.pruebaspring.controller;

import com.miprimerproyecto.pruebaspring.dto.DeportePersonaDTO;
import com.miprimerproyecto.pruebaspring.dto.PersonaDeportistaDTO;
import com.miprimerproyecto.pruebaspring.model.Deporte;
import com.miprimerproyecto.pruebaspring.model.Persona;
import com.miprimerproyecto.pruebaspring.model.PersonaDeporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SportController {


   DeportePersonaDTO deportePersonaDTO = new DeportePersonaDTO();

    @GetMapping(path = "/findSports")
    public List<Deporte> getDeportes(){
            return deportePersonaDTO.getDeporteList();
    }

    @PostMapping(path = "/SetfindSports")
    public ResponseEntity<Deporte> setDeportes(@RequestBody List<Deporte> deportes){

        deportePersonaDTO.setDeporteList(deportes);

        return new ResponseEntity(deportePersonaDTO.getDeporteList(), HttpStatus.OK);
    }

    @GetMapping(path = "/findPerson")
    public List<Persona> getPersona(){
        return deportePersonaDTO.getPersonaList();
    }

    @PostMapping(path = "/SetfindPerson")
    public ResponseEntity<Deporte> setPersona(@RequestBody List<Persona> personas){

        deportePersonaDTO.setPersonaList(personas);

        return new ResponseEntity(deportePersonaDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/findSportName")
    public int getDeporte(@RequestParam String name){

        return deportePersonaDTO.getDeporte(name);
    }

    @PostMapping(path = "/setSportPerson")
    public ResponseEntity<String> setSportPerson(@RequestBody PersonaDeporte personaDeporte){
        deportePersonaDTO.addPersonaDeporte(personaDeporte);
        return new ResponseEntity("Exitoso",HttpStatus.OK);
    }

    @GetMapping(path = "/findSportPerson")
    public List<PersonaDeportistaDTO> getPesonaDeportistaDTO(){

        return deportePersonaDTO.getPesonaDeportistaDTO();
    }






}
