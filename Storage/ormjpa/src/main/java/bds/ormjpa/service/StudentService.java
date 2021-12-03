package bds.ormjpa.service;

import bds.ormjpa.dtos.StudentDTO;
import bds.ormjpa.model.Student;
import bds.ormjpa.repositories.ImplStudentRepository;
import bds.ormjpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    ImplStudentRepository studentRepository;

    public StudentService(ImplStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Long addStudent(StudentDTO studentDTO){
        studentRepository.addStudent(new Student(studentDTO));
    }
}
