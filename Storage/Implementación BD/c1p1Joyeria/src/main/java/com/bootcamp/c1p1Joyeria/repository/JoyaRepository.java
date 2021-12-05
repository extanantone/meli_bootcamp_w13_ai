package com.bootcamp.c1p1Joyeria.repository;

import com.bootcamp.c1p1Joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya, Long> {
}
