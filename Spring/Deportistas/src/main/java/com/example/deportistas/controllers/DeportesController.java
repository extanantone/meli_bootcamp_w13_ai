package com.example.deportistas.controllers;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.dto.PersonasDeporteDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import com.example.deportistas.services.DeportistasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportesController {

    @GetMapping("/findSports")
    public List<DeporteDTO> encontrarDeportes(){
        List<DeporteDTO> response = new ArrayList<>();
        DeportistasService service = new DeportistasService();
        List<Deporte> deportesRaw = service.encontrarDeportes();
        for(Deporte deporte : deportesRaw) {
            response.add(new DeporteDTO(deporte.getNombre(),deporte.getNivel()));
        }
        return response;
    }

    @GetMapping("/findSport/{name}")
    public DeporteDTO encontrarDeporte(@PathVariable String name){
        DeportistasService service = new DeportistasService();
        Deporte deporte = service.encontrarDeporte(name);
        return new DeporteDTO(deporte.getNombre(), deporte.getNivel());
    }

    @GetMapping("/findSportsPersons")
    public List<PersonasDeporteDTO> encontrarPersonasDeporte(){
        DeportistasService service = new DeportistasService();
        return service.encontrarPersonasDeporte();
    }
}
