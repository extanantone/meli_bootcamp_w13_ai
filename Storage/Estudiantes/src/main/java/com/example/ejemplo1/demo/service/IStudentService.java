package com.example.ejemplo1.demo.service;

import com.example.ejemplo1.demo.DTO.DTOStudent;
import com.example.ejemplo1.demo.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService {

    public ResponseEntity<Long> createStudent (DTOStudent studentDTO);


    ResponseEntity<List> getAllStudent();

    ResponseEntity<Student> updateStudent(Student student);
}
