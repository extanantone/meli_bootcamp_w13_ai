package com.meliboopcamp.implementacionDB.c2Practica.repository;


import com.meliboopcamp.implementacionDB.c2Practica.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepositoryI extends JpaRepository<Movie, Long> {
}
