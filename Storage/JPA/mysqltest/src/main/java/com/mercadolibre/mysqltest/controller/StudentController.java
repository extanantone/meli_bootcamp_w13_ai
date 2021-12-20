package com.mercadolibre.mysqltest.controller;

import com.mercadolibre.mysqltest.Service.IStudentService;
import com.mercadolibre.mysqltest.Service.StudentService;
import com.mercadolibre.mysqltest.dto.StudentDTO;
import com.mercadolibre.mysqltest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @PostMapping("student/add")
    public ResponseEntity<?> createUser(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.createStudent(studentDTO), HttpStatus.OK);
    }
}
