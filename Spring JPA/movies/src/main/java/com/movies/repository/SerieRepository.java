package com.movies.repository;

import com.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SerieRepository extends JpaRepository<Serie,Long> {
}
