package com.example.updatestudent.service;

import com.example.updatestudent.model.Student;
import com.example.updatestudent.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class StudentService {

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        if (!studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        }
        throw new EntityExistsException("student with id: " + student.getId() + " already exists.");
    }

    public List<Student> saveStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow();
    }

    public void deteleStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(Student student) {
        Student existingStudent = studentRepository.findById(student.getId()).orElseThrow();
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
}
