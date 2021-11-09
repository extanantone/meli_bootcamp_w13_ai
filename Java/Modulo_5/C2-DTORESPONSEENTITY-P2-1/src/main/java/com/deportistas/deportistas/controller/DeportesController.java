package com.deportistas.deportistas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportesController {

    @GetMapping("/findSports")
    public List<String> FindSportsController(){

        List<String> deportes = List.of("futbol", "basket");

        return deportes;
    }
}
