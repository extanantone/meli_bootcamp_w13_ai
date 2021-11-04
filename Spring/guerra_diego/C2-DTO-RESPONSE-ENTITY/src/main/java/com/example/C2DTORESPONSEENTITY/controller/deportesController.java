package com.example.C2DTORESPONSEENTITY.controller;

import com.example.C2DTORESPONSEENTITY.dto.DeportePersonaDto;
import com.example.C2DTORESPONSEENTITY.model.Deporte;
import com.example.C2DTORESPONSEENTITY.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class deportesController {

    Deporte deporte = new Deporte();
    Persona persona = new Persona();

    ArrayList<Deporte> listDeportes = new ArrayList<>();
    ArrayList<Persona> listPersonas = new ArrayList<>();

    @GetMapping("/findSports")
    public List<Deporte> findSports(){

        return listDeportes;
    }

    @GetMapping("/createPersons")
    public void createPersons(){
        listPersonas.add(new Persona("Bruno","Diaz",40,listDeportes.get(0)));
        listPersonas.add(new Persona("Clark","Kent",41, listDeportes.get(1)));
        listPersonas.add(new Persona("Mario","Bross",55, listDeportes.get(2)));

    }

    @GetMapping("/createSports")
    public void createSports(){
        listDeportes.add(new Deporte("Futbol","Alto"));
        listDeportes.add(new Deporte("Caminata","Medio"));
        listDeportes.add(new Deporte("Natacion","Alto"));
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name){
        Deporte dp = listDeportes.stream()
                .filter(x -> name.equals(x.getNombre()))
                .findAny()
                .orElse(null);

        if (dp != null){
            return new ResponseEntity<>("El nivel de " + name + " es " + dp.getNivel(), HttpStatus.OK);

        }
        else{
            return new ResponseEntity<>("Deporte "+name + " no encontrado",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public List<DeportePersonaDto> findSportsPersons(){

        List<DeportePersonaDto> listDeportePersonas = new ArrayList<>();
        for (Persona p: listPersonas) {
            DeportePersonaDto deportePersonas = new DeportePersonaDto();

            deportePersonas.setNombre(p.getNombre());
            deportePersonas.setApellido(p.getApellido());
            deportePersonas.setDeporte(p.getDeporte().getNombre());
            listDeportePersonas.add(deportePersonas);
        }
        return listDeportePersonas;
    }
}