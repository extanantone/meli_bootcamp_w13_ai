package com.bootcamp.movies_actors.controller;

import com.bootcamp.movies_actors.model.Actor;
import com.bootcamp.movies_actors.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private IActorRepository actorRepo;

    @GetMapping
    public List<Actor> getActores(){
        return actorRepo.findAll();
    }
}
