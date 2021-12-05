package com.bootcamp.demoHibernate.controller;

import com.bootcamp.demoHibernate.dto.StudentRequestDTO;
import com.bootcamp.demoHibernate.dto.StudentResponseDTO;
import com.bootcamp.demoHibernate.exceptions.StudentExistException;
import com.bootcamp.demoHibernate.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO studentRequestDTO) throws StudentExistException {
        return studentService.createStudent(studentRequestDTO);
    }
    @GetMapping("/students")
    public List<StudentResponseDTO> getAllUsers(){
        return studentService.getAllStudents();
    }

}
