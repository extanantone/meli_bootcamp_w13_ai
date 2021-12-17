package com.meliboopcamp.implementacionDB.c2Practica.repository;


import com.meliboopcamp.implementacionDB.c2Practica.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeasonRepositoryI extends JpaRepository<Season, Long> {
}
