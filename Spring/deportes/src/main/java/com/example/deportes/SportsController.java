package com.example.deportes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SportsController {

    public List<Persona> personas = new ArrayList<>();
    public List<Deporte> deportes = new ArrayList<>();
    public List<DTODeportista> deportistas = new ArrayList<>();

    private void createPersonas() {
        personas.add(new Persona("Pepe", "1", 30));
        personas.add(new Persona("Pepe", "2", 32));
        personas.add(new Persona("Pepe", "3", 33));
    }

    private void createDeportes() {
        deportes.add(new Deporte("Ciclismo", 10));
        deportes.add(new Deporte("Semi Ciclismo", 5));
        deportes.add(new Deporte("Anti Ciclismo", 0));
    }

    private void createDeportistas() {
        deportistas.add(new DTODeportista(personas.get(0).nombre + " " + personas.get(0).apellido, deportes.get(2).nombre));
        deportistas.add(new DTODeportista(personas.get(1).nombre + " " + personas.get(1).apellido, deportes.get(1).nombre));
        deportistas.add(new DTODeportista(personas.get(2).nombre + " " + personas.get(2).apellido, deportes.get(0).nombre));
    }

    @GetMapping("/findsports")
    public List<Deporte> findSports() {
        if (!deportes.isEmpty()) {
            return deportes;
        } else {
            this.createDeportes();
            this.createPersonas();
            this.createDeportistas();
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Los deportes fueron creados :)");
        }
    }

    @GetMapping("/findsports/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name) {
        if (!deportes.isEmpty()) {
            for (Deporte deporte : deportes) {
                if (deporte.nombre.equals(name)) {
                    return new ResponseEntity<>(deporte.nivel.toString(), HttpStatus.OK);
                }
            }
            return new ResponseEntity<>("Nope, no existe", HttpStatus.NOT_FOUND);
        } else {
            this.createDeportes();
            this.createPersonas();
            this.createDeportistas();
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Los deportes fueron creados :)");
        }
    }

    @GetMapping("/findsportspeople")
    public List<DTODeportista> findSportsPeople() {
        if (!deportistas.isEmpty()) {
            return deportistas;
        } else {
            this.createDeportes();
            this.createPersonas();
            this.createDeportistas();
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Los deportes fueron creados :)");
        }
    }

}
