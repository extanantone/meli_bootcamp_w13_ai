package com.meli.probandojpa.service;

import com.meli.probandojpa.dto.StudentDTO;
import com.meli.probandojpa.exceptio.UserDuplicateException;
import com.meli.probandojpa.model.Student;
import com.meli.probandojpa.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    ModelMapper mapper = new ModelMapper();
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Long addStudent(StudentDTO studentDTO) {

        Student student = studentRepository.findById(studentDTO.getId()).orElse(null);

        if (student != null) {
            throw new UserDuplicateException(studentDTO.getId());
        }


        studentRepository.save(mapper.map(studentDTO, Student.class));

        return studentDTO.getId();
    }


}
