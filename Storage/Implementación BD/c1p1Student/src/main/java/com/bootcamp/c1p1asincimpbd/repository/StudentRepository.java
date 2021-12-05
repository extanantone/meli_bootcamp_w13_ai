package com.bootcamp.c1p1asincimpbd.repository;

import com.bootcamp.c1p1asincimpbd.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByDni(String dni);
}
