package bds.ormjpa.service;

import bds.ormjpa.dtos.StudentDTO;
import bds.ormjpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Long addStudent(StudentDTO studentDTO){

    }
}
