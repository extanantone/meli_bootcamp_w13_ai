package com.meliboopcamp.implementacionDB.c2Practica.repository;


import com.meliboopcamp.implementacionDB.c2Practica.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ActorRepositoryI extends JpaRepository<Actor, Long> {

    List<Actor> findActorByFirstNameEquals(String firstname);

    @Query("from Actor   a where a.favoriteMovie.id is not null")
    List<Actor> findActorByFavoriteMovieExists();
}
