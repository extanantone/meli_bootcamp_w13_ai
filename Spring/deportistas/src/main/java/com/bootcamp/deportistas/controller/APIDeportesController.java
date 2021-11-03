package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.PersonaDTO;
import com.bootcamp.deportistas.service.Deporte;
import com.bootcamp.deportistas.service.Persona;
import com.bootcamp.deportistas.service.RepositorioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        String nivel = repositorio.buscarDeporte(name);
        if(nivel == null){
            return new ResponseEntity<>("No se ha encontrado tal deporte", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("El nivel del deporte " + name + " es " + nivel, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> listarDeportistas(){
        List<PersonaDTO> deportistas = new ArrayList<>();
        List<Persona> personas = repositorio.getListaPersonas();

        for (Persona p : personas) { //va filtrando las personas que son deportistas y esas devuelve
            if(p.esDeportista()){
                deportistas.add(new PersonaDTO(p.getNombre() + " " + p.getApellido(),
                        p.getDeportesQueRealiza().stream().map(x -> x.getNombre()).collect(Collectors.toList())));
            }
        }

        if(deportistas.size() > 0){ //hay algun deportista?
            return new ResponseEntity<>(deportistas, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    /*@PostMapping("/personas")
    public ResponseEntity<String> crearPersona(@RequestBody Persona persona){
        repositorio.registrarPersona(persona);
        return new ResponseEntity<>("Persona registrada exitosamente", HttpStatus.OK);
    }*/

    @PostMapping("/deportes")
    public ResponseEntity<String> crearDeporte(@RequestBody Deporte deporte){
        if(deporte.getNombre() == null){
            return new ResponseEntity<>("Falta especificar el nombre", HttpStatus.BAD_REQUEST);
        }else if(deporte.getNivel() == null){
            return new ResponseEntity<>("Falta especificar el nivel", HttpStatus.BAD_REQUEST);
        }
        repositorio.agregarDeporte(deporte);
        return new ResponseEntity<>("Deporte creado exitosamente", HttpStatus.OK);
    }
}
