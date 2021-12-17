package demo.movies.controller;

import demo.movies.entity.Actor;
import demo.movies.entity.Genre;
import demo.movies.repository.ActorRepositoryI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {

    ActorRepositoryI actorRepository;

    ActorController(ActorRepositoryI actorRepository) {
        this.actorRepository = actorRepository;
    }


    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }


    @GetMapping("/actors/all")
    public List<Actor> getAllActors(){
        return actorRepository.findActor();
    }

    @GetMapping("/actors/favoritemovie")
    public List<Actor> getActorsWhoHaveFavoriteMovie(){
        return actorRepository.findActorWhichHaveFavouriteMovies();
    }



}
