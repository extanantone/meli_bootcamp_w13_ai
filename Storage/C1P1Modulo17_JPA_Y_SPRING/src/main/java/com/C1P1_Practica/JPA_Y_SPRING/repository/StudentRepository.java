package com.C1P1_Practica.JPA_Y_SPRING.repository;

import com.C1P1_Practica.JPA_Y_SPRING.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {

}
