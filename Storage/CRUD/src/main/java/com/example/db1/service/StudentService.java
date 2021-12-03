package com.example.db1.service;

import com.example.db1.dto.StudentDto;
import com.example.db1.exception.BadRequestException;
import com.example.db1.model.Student;
import com.example.db1.repository.StudentRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    ModelMapper modelMapper = new ModelMapper();


    public void createStudent (StudentDto studentDto) {

        Student student = modelMapper.map(studentDto,Student.class);

        Optional<Student> studentById = repository.findById(student.getId());

        if(studentById.isPresent()) {
            throw new BadRequestException("id ya existe");
        }

        Student response = repository.save(student);


    }

    public List<StudentDto> getStudents () {
        return repository.findAll().stream()
                .map(x -> modelMapper.map(x,StudentDto.class))
                .collect(Collectors.toList());

    }

    public StudentDto updateStudent (StudentDto studentDto) {
        Student studentById = repository
                .findById(studentDto.getId())
                .orElseThrow(() -> new BadRequestException("usuario no existe con id: " + studentDto.getId()));

        Student student = modelMapper.map(studentDto,Student.class);


        return modelMapper.map(repository.save(student),StudentDto.class);
    }
}
