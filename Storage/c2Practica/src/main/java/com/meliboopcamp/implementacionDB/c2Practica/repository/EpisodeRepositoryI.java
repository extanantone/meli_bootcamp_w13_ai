package com.meliboopcamp.implementacionDB.c2Practica.repository;


import com.meliboopcamp.implementacionDB.c2Practica.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EpisodeRepositoryI extends JpaRepository<Episode, Long> {
}
