package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;


    @PostMapping("/prueba")
    public String prueba(){
        return "prueba";
    }

    @PostMapping("/notaPromedio")
    public StudentDTO notasPromedio(@RequestBody @Valid StudentDTO rq) {
        return service.notas(rq);
    }

}
