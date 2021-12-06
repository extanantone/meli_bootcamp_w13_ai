package com.bootcamp.movies_actors.repository;

import com.bootcamp.movies_actors.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorRepository extends JpaRepository<Actor,Long> {
}
