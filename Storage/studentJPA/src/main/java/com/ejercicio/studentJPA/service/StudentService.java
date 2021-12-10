package com.ejercicio.studentJPA.service;
import com.ejercicio.studentJPA.dto.StudentDTO;
import com.ejercicio.studentJPA.exception.UserAlreadyExistsException;
import com.ejercicio.studentJPA.exception.UserNotFoundException;
import com.ejercicio.studentJPA.model.Student;
import com.ejercicio.studentJPA.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public StudentDTO addStudent(StudentDTO studentDTO){
        ModelMapper modelMapper = new ModelMapper();
        Student student = new Student(studentDTO.getId(),studentDTO.getDni(),studentDTO.getName(),studentDTO.getLastName());
        if (studentRepository.existsById(student.getId())){
            throw new UserAlreadyExistsException();
        }
        studentRepository.save(student);
        return modelMapper.map(student,StudentDTO.class);
    }

    public List<StudentDTO> listStudents(){
        ModelMapper modelMapper = new ModelMapper();
        return studentRepository.findAll().stream()
                .map(student -> modelMapper.map(student,StudentDTO.class))
                .collect(Collectors.toList());
    }

    public StudentDTO updateStudent(StudentDTO studentDTO){
        ModelMapper modelMapper = new ModelMapper();
        Student student = new Student(studentDTO.getId(),studentDTO.getDni(),studentDTO.getName(),studentDTO.getLastName());
        if (!studentRepository.existsById(student.getId())){
            throw new UserNotFoundException();
        }
        studentRepository.save(student);
        return modelMapper.map(student,StudentDTO.class);
    }
}
