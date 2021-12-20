package com.mercadolibre.jpatest.Service;

import com.mercadolibre.jpatest.Repository.StudentRepository;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
