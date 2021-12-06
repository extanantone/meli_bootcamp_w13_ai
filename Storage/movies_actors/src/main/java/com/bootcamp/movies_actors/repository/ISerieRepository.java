package com.bootcamp.movies_actors.repository;

import com.bootcamp.movies_actors.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISerieRepository extends JpaRepository<Serie,Long> {
}
