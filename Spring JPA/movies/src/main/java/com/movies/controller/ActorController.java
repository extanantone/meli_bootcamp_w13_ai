package com.movies.controller;

import com.movies.model.Actor;
import com.movies.model.Movie;
import com.movies.repository.ActorRepository;
import com.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/actors")
    public List<Actor> getActors(){
        return actorRepository.findAll();
    }

    @GetMapping("movies/{idMovie}/actors")
    public List<Actor> getActorsInMovie(@PathVariable int idMovie){
        System.out.println(idMovie);
        return actorRepository.findActorInMovie(movieRepository.findById(idMovie).get());
    }

    @GetMapping("/movies")
    public List<Movie> fundMoviesByActorsRating(@RequestParam(defaultValue = "0") double rating ){
        return movieRepository.getMoviesWithRatingActorsBigThat(rating);
    }



}
