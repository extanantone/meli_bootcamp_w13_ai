package com.example.demo.controller;

import com.example.demo.model.Deporte;
import com.example.demo.service.DeporteServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeporteController {
    DeporteServices ds = new DeporteServices();
    //Ejercicio 1, anduvo de 10
    @GetMapping("/findSport")
    public ResponseEntity<List<Deporte>> todosLosDeportes(){
        ds.inicializarDeportes();

        List<Deporte> listaDeportes = ds.listaDeportes;

        return new ResponseEntity(listaDeportes, HttpStatus.OK);
    }
    //Ejercicio 2 , anduvo de 10
    @GetMapping("/findSport/{nombreDeporte}")
    public ResponseEntity<?> buscarDeporte(@PathVariable String nombreDeporte) {
        ds.inicializarDeportes();
        return ds.buscarDeporte(nombreDeporte);
    }



}
