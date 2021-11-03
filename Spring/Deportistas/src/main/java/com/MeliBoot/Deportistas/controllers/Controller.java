package com.MeliBoot.Deportistas.controllers;

import com.MeliBoot.Deportistas.models.Deporte;
import com.MeliBoot.Deportistas.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    Deporte deporte;

    Persona persona;

    @GetMapping("/findSports")
    public List<Deporte> getSports(){
        return
    }
}
