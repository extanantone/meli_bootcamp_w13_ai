package com.bootcamp.c1p1asincimpbd.service;

import com.bootcamp.c1p1asincimpbd.dto.StudentRequestDTO;
import com.bootcamp.c1p1asincimpbd.dto.StudentResponseDTO;

import java.util.List;

public interface IStudentService {
    StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO);

    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO updateStudent(StudentResponseDTO studentResponseDTO);
}
