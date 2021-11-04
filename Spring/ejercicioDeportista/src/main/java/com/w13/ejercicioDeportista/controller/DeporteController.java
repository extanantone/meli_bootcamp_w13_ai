package com.w13.ejercicioDeportista.controller;

import com.w13.ejercicioDeportista.dto.PersonaDto;
import com.w13.ejercicioDeportista.entity.Deporte;
import com.w13.ejercicioDeportista.service.DeporteService;
import com.w13.ejercicioDeportista.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeporteController {

    DeporteService deporteService = new DeporteService();
    PersonaService personaService = new PersonaService();
    PersonaDto personaDto = new PersonaDto();


    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findAllDeporte() {

        // deporteService.cargaListaDeporte();

        return new ResponseEntity(deporteService.cargaListaDeporte(), HttpStatus.OK);
    }


    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findDeporteByName(@PathVariable("name") String nombre) {

        List<Deporte> deportes = deporteService.cargaListaDeporte();

        List<Deporte> deporteFil = deportes.stream().filter(d -> d.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());

        if (!deporteFil.isEmpty()) {

            return new ResponseEntity(deporteFil.get(0).getNivel(), HttpStatus.OK);

        } else {

            return new ResponseEntity("No se escontro el Deporte " + nombre, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDto>> findDeportesPersona() {


        return new ResponseEntity(personaService.cargaPersonDto(), HttpStatus.OK);

    }


}
