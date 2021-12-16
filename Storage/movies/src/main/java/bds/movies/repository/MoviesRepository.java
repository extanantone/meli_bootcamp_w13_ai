package bds.movies.repository;

import bds.movies.model.Movies;
import bds.movies.service.MoviesService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {
//    @Query("from Movies m where m.id = :id")
    Movies findMoviesById(@Param("id") Integer id);
}
