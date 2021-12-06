package com.bootcamp.movies_actors.controller;

import com.bootcamp.movies_actors.model.Serie;
import com.bootcamp.movies_actors.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private ISerieRepository serieRepo;

    @GetMapping
    public List<Serie> getSeries(){
        return serieRepo.findAll();
    }
}
