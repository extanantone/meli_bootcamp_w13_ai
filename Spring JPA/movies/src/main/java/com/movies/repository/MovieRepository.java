package com.movies.repository;

import com.movies.model.Genre;
import com.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query("from Movie m  where m not in (select m1 from Movie  m1 join m1.actors actor where actor.rating<:ranting)")
    List<Movie> getMoviesWithRatingActorsBigThat(@Param("ranting") double ranting);

    @Query("from Movie m where m.genre=:genre")
    List<Movie> findMovieByGenre(@Param("genre") Genre genre);

}
