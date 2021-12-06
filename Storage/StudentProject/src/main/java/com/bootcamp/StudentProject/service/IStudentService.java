package com.bootcamp.StudentProject.service;

import com.bootcamp.StudentProject.dto.StudentRequestDTO;
import com.bootcamp.StudentProject.dto.StudentResponseDTO;

public interface IStudentService {
    StudentResponseDTO addStudent(StudentRequestDTO studentRequestDTO);
}