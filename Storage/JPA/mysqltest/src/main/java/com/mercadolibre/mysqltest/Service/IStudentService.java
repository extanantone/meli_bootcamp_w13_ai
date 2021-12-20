package com.mercadolibre.mysqltest.Service;

import com.mercadolibre.mysqltest.dto.ResponseDTO;
import com.mercadolibre.mysqltest.dto.StudentDTO;
import com.mercadolibre.mysqltest.model.Student;
import org.springframework.http.ResponseEntity;

public interface IStudentService{
    ResponseDTO createStudent(StudentDTO studentDTO);
}
