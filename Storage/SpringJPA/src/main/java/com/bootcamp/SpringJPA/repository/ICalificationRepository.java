package com.bootcamp.SpringJPA.repository;

import com.bootcamp.SpringJPA.model.Calification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICalificationRepository extends JpaRepository<Calification, Long> {
}
