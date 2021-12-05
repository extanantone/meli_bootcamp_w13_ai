package com.bootcamp.demoHibernate.repository;

import com.bootcamp.demoHibernate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository <Student, Long>{
    Optional<Student> findByDni(String dni);
}
