package ruiz_facundo.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ruiz_facundo.movies.entity.Movie;

@Repository
public interface MovieRepositoryI extends JpaRepository<Movie, Long> {
}
