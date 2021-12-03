package com.student.service;

import com.student.dto.StudentRequestDto;
import com.student.dto.StudentResponseDto;
import com.student.exceptions.StudentFoundException;
import com.student.exceptions.StudentNotFound;
import com.student.model.Student;
import com.student.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private ModelMapper mapper = new ModelMapper();

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto){
        Student student = mapper.map(studentRequestDto,Student.class);
        Optional<Student> exist = studentRepository.findByDni(student.getDni());
        if(exist.isPresent())
            throw  new StudentFoundException(student.getDni());
        return mapper.map(studentRepository.save(student),StudentResponseDto.class);
    }

    public List<StudentResponseDto> getAllStudents() {

        return studentRepository.findAll().stream()
                .map(s->mapper.map(s,StudentResponseDto.class)).collect(Collectors.toList());
    }

    public StudentResponseDto updateStudent(StudentResponseDto dto) {
        Student student = mapper.map(dto,Student.class);
        if(!studentRepository.existsById(student.getId()))
            throw new StudentNotFound(student.getId());
        studentRepository.save(student);
        return dto;
    }
}
