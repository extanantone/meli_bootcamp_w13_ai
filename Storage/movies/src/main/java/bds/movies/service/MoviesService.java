package bds.movies.service;

import bds.movies.dto.GenreDto;
import bds.movies.dto.MoviesDto;
import bds.movies.model.Movies;
import bds.movies.repository.MoviesRepository;
import org.springframework.stereotype.Service;

@Service
public class MoviesService {
    MoviesRepository moviesRepository;

    public MoviesService(MoviesRepository moviesRepository){
        this.moviesRepository = moviesRepository;
    }

    public MoviesDto findMovieById(Integer id){
        Movies movies = moviesRepository.findMoviesById(id);
        GenreDto genreDto = new GenreDto(movies.getGenres().getName(), movies.getGenres().getRanking(), movies.getGenres().getActive());
        return new MoviesDto(movies.getTitle(), movies.getRating(), movies.getAwards(), movies.getAwards(), genreDto);
    }
}

