package ejerciciodeportista.bootcamp.controllers;

import ejerciciodeportista.bootcamp.DTO.DeporteDTO;
import ejerciciodeportista.bootcamp.DTO.DeportistasDTO;
import ejerciciodeportista.bootcamp.DTO.NivelDeporteDTO;
import ejerciciodeportista.bootcamp.services.Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.*;

import java.awt.*;
import java.util.List;

@RestController
public class Controller {
    Services services;

    public Controller(){
        services = new Services();
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO> > verDeportes(){
        List<DeporteDTO> deporteDTOList = new ArrayList<>();
        services.getDeporteList().forEach(d -> deporteDTOList.add(new DeporteDTO(d.getNombre(), d.getNivel())));
        return new ResponseEntity<>(deporteDTOList, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<NivelDeporteDTO> consultarNivelDeporte(@PathVariable String name){
        String nivel = services.getNivelDeporte(name);
        if (nivel != null){
            NivelDeporteDTO nivelDeporteDTO = new NivelDeporteDTO("");
            nivelDeporteDTO.setNivel(nivel);
            return new ResponseEntity<>(nivelDeporteDTO, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistasDTO> > consultarDeportistas(){
        List<DeportistasDTO> deportistasDTOList = new ArrayList<>();
        services.getDeportistas().forEach(p -> deportistasDTOList.add(new DeportistasDTO(p.getName(), p.getLastname(), p.getDeporte().getNombre())));
        if(deportistasDTOList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(deportistasDTOList, HttpStatus.OK);
    }

}
