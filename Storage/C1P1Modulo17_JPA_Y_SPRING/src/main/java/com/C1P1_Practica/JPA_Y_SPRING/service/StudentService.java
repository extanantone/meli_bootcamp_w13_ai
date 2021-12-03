package com.C1P1_Practica.JPA_Y_SPRING.service;

import com.C1P1_Practica.JPA_Y_SPRING.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository stuRepo;

    public StudentService(StudentRepository stuRepo){
        this.stuRepo = stuRepo;
    }
}
