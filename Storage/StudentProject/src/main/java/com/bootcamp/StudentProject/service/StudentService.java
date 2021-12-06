package com.bootcamp.StudentProject.service;

import com.bootcamp.StudentProject.dto.StudentRequestDTO;
import com.bootcamp.StudentProject.dto.StudentResponseDTO;
import com.bootcamp.StudentProject.exception.StudentAlreadyExistsException;
import com.bootcamp.StudentProject.model.Student;
import com.bootcamp.StudentProject.repository.IStudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    private final IStudentRepository studentRepository;

    ModelMapper mapper = new ModelMapper();

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO studentRequestDTO) {
        Student student = mapper.map(studentRequestDTO, Student.class);

        Optional<Student> optionalStudent = studentRepository.findByDni(student.getDni());

        if (optionalStudent.isPresent()) {
            throw new StudentAlreadyExistsException(student.getDni());
        } else {
            studentRepository.save(student);
        }

        return mapper.map(student, StudentResponseDTO.class);
    }
}