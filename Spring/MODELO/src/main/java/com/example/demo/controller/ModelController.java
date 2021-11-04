package com.example.demo.controller;

import java.util.List;

@RestController
public class ModelController {
    @GetMapping("/findSport")
    public ResponseEntity<List<Deporte>> todosLosDeportes(){
        ds.inicializarDeportes();

        List<Deporte> listaDeportes = ds.listaDeportes;

        return new ResponseEntity(listaDeportes, HttpStatus.OK);
    }
}
