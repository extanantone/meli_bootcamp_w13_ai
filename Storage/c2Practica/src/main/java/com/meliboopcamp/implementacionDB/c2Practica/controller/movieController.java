package com.meliboopcamp.implementacionDB.c2Practica.controller;

import com.meliboopcamp.implementacionDB.c2Practica.dtos.ActorDTO;
import com.meliboopcamp.implementacionDB.c2Practica.model.Actor;
import com.meliboopcamp.implementacionDB.c2Practica.service.ArctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class movieController {

    @Autowired
    ArctorService arctorService;

    @GetMapping(path = "/actors")
    public List<ActorDTO> obteneractors() {

        List<ActorDTO> actors = arctorService.obtenerAcvtorsFavoriteMoviesExist();

        return  actors;
    }





}
