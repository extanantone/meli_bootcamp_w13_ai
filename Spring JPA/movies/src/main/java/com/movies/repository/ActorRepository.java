package com.movies.repository;

import com.movies.model.Actor;
import com.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Long> {

    @Query("from Actor actor where actor.favoriteMovie is not null")
    List<Actor> findtActorsWithFavoriteMovie();


    List<Actor> findByRatingGreaterThanEqual(double rating);

    @Query("from Actor actor where actor.id in (select m.id from Movie m where m=:movie)")
    List<Actor> findActorInMovie(@Param("movie") Movie movie);

}
