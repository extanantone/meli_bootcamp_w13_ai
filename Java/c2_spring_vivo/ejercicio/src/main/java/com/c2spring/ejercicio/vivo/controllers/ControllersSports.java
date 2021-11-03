package com.c2spring.ejercicio.vivo.controllers;

import com.c2spring.ejercicio.vivo.modelo.Deporte;
import com.c2spring.ejercicio.vivo.modelo.Persona;
import com.c2spring.ejercicio.vivo.modelo.Repositorio;
import com.c2spring.ejercicio.vivo.servicio.SportyPersonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sports")
public class ControllersSports {

    @GetMapping("/")
    public String prueba(){
        return "Hola si funciono";
    }
    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports(){
        return new ResponseEntity<>(Repositorio.showDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Deporte> findSportsName(@PathVariable String name) {
        return new ResponseEntity<>(Repositorio.findDeporte(name), HttpStatus.OK);
    }

    @GetMapping("/findSportyPersons")
    public ResponseEntity<List<SportyPersonDTO>> findSportyPersons(){
        List<Persona> temp = Repositorio.showPersonas();
        List<SportyPersonDTO> personasDeportistas = new ArrayList<>();
        temp.forEach(x->{
            personasDeportistas.add(new SportyPersonDTO(x.getNombre(),x.getApellido(),x.getDeporte().getNombre()));
        });
        return new ResponseEntity<>(personasDeportistas, HttpStatus.OK);
    }



}
