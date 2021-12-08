package com.bootcamp.SpringJPA.service;

import com.bootcamp.SpringJPA.dto.CalificationDTO;
import com.bootcamp.SpringJPA.dto.StudentDTO;
import com.bootcamp.SpringJPA.dto.SuccessDTO;

import java.util.List;

public interface IStudentService {
    SuccessDTO createStudent(StudentDTO studentDTO);
    List<StudentDTO> getStudents();
    StudentDTO updateStudent(StudentDTO studentDTO);
    SuccessDTO deleteStudent(Long studentId);

    SuccessDTO addCalification(CalificationDTO calificationDTO);
    List<CalificationDTO> getCalifications(Long studentId);
}
