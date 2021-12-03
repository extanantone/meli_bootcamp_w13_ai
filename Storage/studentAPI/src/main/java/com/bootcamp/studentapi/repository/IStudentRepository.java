package com.bootcamp.studentapi.repository;

import com.bootcamp.studentapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> getStudentByEmail(String email);
}
