package com.example.JPASpring.repository;

import com.example.JPASpring.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository <Student, Long> {

}
