package com.bootcamp.C2P2EJ1.controller;

import com.bootcamp.C2P2EJ1.dto.DTOPersonaDeportista;
import com.bootcamp.C2P2EJ1.model.Deporte;
import com.bootcamp.C2P2EJ1.service.DatosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaDeportistaController {
    private static DatosService datosService = new DatosService();

    @GetMapping("/findSports")
    public static List<Deporte> mostrarDeportes() {
        return datosService.mostrarTodosLosDeportes();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Integer> mostrarDeporte(@PathVariable("name") String name) {
        return datosService.mostrarDeporteParticular(name);
    }

    @GetMapping("/findSportPersons")
    public static List<DTOPersonaDeportista> mostrarPersonaDeportista() {
        return datosService.mostrarPersonaDeportista();
    }
}
