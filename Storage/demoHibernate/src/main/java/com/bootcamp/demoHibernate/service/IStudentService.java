package com.bootcamp.demoHibernate.service;

import com.bootcamp.demoHibernate.dto.StudentRequestDTO;
import com.bootcamp.demoHibernate.dto.StudentResponseDTO;
import com.bootcamp.demoHibernate.exceptions.StudentExistException;

import java.util.List;

public interface IStudentService {
    StudentResponseDTO createStudent( StudentRequestDTO student) throws StudentExistException;
    List<StudentResponseDTO> getAllStudents();
}
