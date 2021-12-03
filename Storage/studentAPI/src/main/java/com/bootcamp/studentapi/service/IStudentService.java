package com.bootcamp.studentapi.service;

import com.bootcamp.studentapi.dto.request.StudentDTO;
import com.bootcamp.studentapi.dto.response.CreatedStudentDTO;

public interface IStudentService {

    CreatedStudentDTO createStudent(StudentDTO studentDTO);

}
