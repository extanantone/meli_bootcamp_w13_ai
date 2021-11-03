package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.service.Deporte;
import com.bootcamp.deportistas.service.Nivel;
import com.bootcamp.deportistas.service.Persona;
import com.bootcamp.deportistas.service.RepositorioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIDeportesController {
    private static RepositorioService repositorio;

    public APIDeportesController() {
        repositorio = new RepositorioService();
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> listarDeportes(){
        return new ResponseEntity<>(repositorio.getListaDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> buscarDeporte(@PathVariable String name){
        Nivel nivel = repositorio.buscarDeporte(name);
        if(nivel == null){
            return new ResponseEntity<>("No se ha encontrado tal deporte", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("El nivel del deporte " + name + " es " + nivel, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<> listarDeportistas(){

    }

    @PostMapping("/personas")
    public void crearPersona(@RequestBody Persona persona){
        repositorio.registrarPersona(persona);
    }

    @PostMapping("/deportes")
    public void crearDeportista(@RequestBody Deporte deporte){
        repositorio.agregarDeporte(deporte);
    }
}
