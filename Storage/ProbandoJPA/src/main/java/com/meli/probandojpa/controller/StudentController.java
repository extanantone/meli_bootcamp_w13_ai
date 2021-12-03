package com.meli.probandojpa.controller;

import com.meli.probandojpa.dto.StudentDTO;
import com.meli.probandojpa.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    final
    StudentService studentService;

    public StudentController(StudentService StudentService) {
        this.studentService = StudentService;
    }


    @PostMapping("student/add")
    public Long addStudent(@RequestBody StudentDTO studentDTO) {

       return studentService.addStudent(studentDTO);


    }
}
