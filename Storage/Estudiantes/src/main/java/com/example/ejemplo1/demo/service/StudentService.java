package com.example.ejemplo1.demo.service;

import com.example.ejemplo1.demo.DTO.DTOStudent;
import com.example.ejemplo1.demo.model.Student;
import com.example.ejemplo1.demo.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;


public StudentService (StudentRepository studentRepository){
    this.studentRepository = studentRepository;
}


    @Override
    public ResponseEntity<Long> createStudent(DTOStudent studentDTO) {

    Student savedStudent;
    Student studentToSave = new Student();
    studentToSave.setDni(studentDTO.getDni());
    studentToSave.setName(studentDTO.getName());
    studentToSave.setLastName(studentDTO.getLastName());
    
    savedStudent = studentRepository.save(studentToSave);

    return new ResponseEntity<>(savedStudent.getId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List> getAllStudent() {
        return new ResponseEntity<>(studentRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Student> updateStudent(Student studentToSave) {
        Student savedStudent = studentRepository.save(studentToSave);

        return new ResponseEntity<>(savedStudent, HttpStatus.OK);
    }
}
