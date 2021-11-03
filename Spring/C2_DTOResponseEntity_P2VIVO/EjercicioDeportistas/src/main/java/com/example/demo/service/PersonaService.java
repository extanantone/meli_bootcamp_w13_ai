package com.example.demo.service;

import com.example.demo.dto.PersonaDeporteDTO;
import com.example.demo.model.Deporte;
import com.example.demo.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaService {
    public List<Persona> listaPersonas = new ArrayList<>();

    public void inicializarPersonas(){
        Deporte d = new Deporte("Basket",2);
        Persona p = new Persona("Sofia","Menichelli",18,d);
        listaPersonas.add(p);
        d = new Deporte("Futbol",2);
        p = new Persona("Rodrigo","Dimare",18,d);
        listaPersonas.add(p);
        d = new Deporte("Natacion",5);
        p = new Persona("Pablo","Guayta",18,d);
        listaPersonas.add(p);

        d = new Deporte("Rugby",3);
        p = new Persona("Luis","Gomez Morales",18,d);
        listaPersonas.add(p);
    }

    public ResponseEntity<List<PersonaDeporteDTO>> buscarPersonasDeportistas(){
        List<PersonaDeporteDTO> lista = listaPersonas.stream().map(PersonaDeporteDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
