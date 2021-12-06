package com.example.Hibernate.PrimerEjercicio.service;

import com.example.Hibernate.PrimerEjercicio.DTOs.StudentDTO;
import com.example.Hibernate.PrimerEjercicio.DTOs.StudentResponseDTO;

import java.util.List;

public interface IStudentService {

    StudentResponseDTO setStudent(StudentDTO studentDTO);
    List<StudentDTO> getStudents();
    StudentDTO updateStudens(StudentDTO studentDTO);
}
