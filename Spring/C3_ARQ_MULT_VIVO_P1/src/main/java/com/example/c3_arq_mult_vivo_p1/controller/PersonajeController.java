package com.example.c3_arq_mult_vivo_p1.controller;

import com.example.c3_arq_mult_vivo_p1.dto.PersonajeDTO;
import com.example.c3_arq_mult_vivo_p1.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/personaje")
public class PersonajeController
{
    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> filterName(@PathVariable String name)
    {
        return new ResponseEntity<>(personajeService.getPersonajes(name), HttpStatus.OK);
    }

}
