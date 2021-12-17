package com.meliboopcamp.implementacionDB.c2Practica.repository;

import com.meliboopcamp.implementacionDB.c2Practica.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepositoryI extends JpaRepository<Series, Long> {
}
