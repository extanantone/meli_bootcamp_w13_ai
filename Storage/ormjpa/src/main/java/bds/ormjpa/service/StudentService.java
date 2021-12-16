package bds.ormjpa.service;

import bds.ormjpa.dtos.StudentDTO;
import bds.ormjpa.dtos.StudentIdDTO;
import bds.ormjpa.model.Student;
import bds.ormjpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentIdDTO addStudent(StudentDTO studentDTO){
        return new StudentIdDTO(studentRepository.save(new Student(studentDTO)).getId());
    }
}
