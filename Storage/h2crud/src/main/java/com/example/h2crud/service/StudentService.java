package com.example.h2crud.service;

import com.example.h2crud.dto.StudentCreateResponseDto;
import com.example.h2crud.dto.StudentDto;
import com.example.h2crud.excepctions.NotFoundException;
import com.example.h2crud.model.Student;
import com.example.h2crud.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    ModelMapper mapper = new ModelMapper();

    public StudentService (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<StudentCreateResponseDto> createStudent (StudentDto studentDto) {
        Optional<Student> student =  studentRepository.findBydni(studentDto.getDni());


        if (student.isPresent()) {
            System.out.println(student.get().getDni());
            throw new NotFoundException("Student already exists");
        }

        Student studentToSave = mapper.map(studentDto, Student.class);

        Long studentIdSaved = studentRepository.save(studentToSave).getId();

        StudentCreateResponseDto response = new StudentCreateResponseDto("El usuario se creo correctamente",studentIdSaved);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
