package demo.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.movies.repository.ActorRepositoryI;
import demo.movies.repository.MovieRepositoryI;

@Service
public class MovieService {
    @Autowired
    private MovieRepositoryI repoMovies;
    @Autowired
    private ActorRepositoryI repoActors;
}
