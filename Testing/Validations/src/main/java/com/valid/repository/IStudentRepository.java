package com.valid.repository;

import com.valid.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository {

    Optional<Student> findByName(String name);
    List<Student> findAll();
    Optional<Student> findById(int id);
    void delete(Student student);

}
