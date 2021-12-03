package com.example.studenth2.service;

import com.example.studenth2.dto.StudentCreationDTO;
import com.example.studenth2.dto.StudentDTO;
import com.example.studenth2.dto.StudentQualificationsDTO;
import com.example.studenth2.exception.StudentNotFoundException;
import com.example.studenth2.mapper.StudentMapper;
import com.example.studenth2.model.Student;
import com.example.studenth2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDTO save(StudentCreationDTO c) {
        Student s = StudentMapper.studentCreationToStudent(c);
        return StudentMapper.studentToDto(studentRepository.save(s));
    }

    public List<StudentDTO> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::studentToDto)
                .collect(Collectors.toList());
    }

    public StudentQualificationsDTO update(StudentQualificationsDTO s) {
        if (!studentRepository.existsById(s.getId()))
            throw new StudentNotFoundException(String.format("Student with id %s doesn't exist", s.getId()));

        Student update = StudentMapper.studentQualificationsToStudent(s);
        studentRepository.save(update);
        return s;
    }
}
