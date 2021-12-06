package com.example.Hibernate.PrimerEjercicio.repository;

import com.example.Hibernate.PrimerEjercicio.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
