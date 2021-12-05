package com.bootcamp.c1p1asincimpbd.controller;

import com.bootcamp.c1p1asincimpbd.dto.StudentRequestDTO;
import com.bootcamp.c1p1asincimpbd.dto.StudentResponseDTO;
import com.bootcamp.c1p1asincimpbd.service.IStudentService;
import com.bootcamp.c1p1asincimpbd.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private IStudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return studentService.createStudent(studentRequestDTO);
    }

    @GetMapping("/students")
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/student/update")
    public StudentResponseDTO updateStudent(@RequestBody StudentResponseDTO studentResponseDTO) {
        return studentService.updateStudent(studentResponseDTO);
    }
}
