package com.bootcamp.studentapi.controller;

import com.bootcamp.studentapi.dto.request.StudentDTO;
import com.bootcamp.studentapi.dto.response.CreatedStudentDTO;
import com.bootcamp.studentapi.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    final private IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreatedStudentDTO> create(@RequestBody @Valid StudentDTO studentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentDTO));
    }
}
