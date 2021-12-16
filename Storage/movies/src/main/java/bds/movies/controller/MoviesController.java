package bds.movies.controller;

import bds.movies.dto.GenreDto;
import bds.movies.dto.MoviesDto;
import bds.movies.model.Movies;
import bds.movies.service.MoviesService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    MoviesService moviesService;

    public MoviesController(MoviesService moviesService){
        this.moviesService = moviesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoviesDto> getMovieFilteringById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findMovieById(id));
    }

}
