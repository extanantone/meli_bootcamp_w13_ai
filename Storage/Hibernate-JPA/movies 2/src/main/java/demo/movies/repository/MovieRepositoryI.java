package demo.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import demo.movies.entity.Movie;

@Repository
public interface MovieRepositoryI extends JpaRepository<Movie, Long> {
}
