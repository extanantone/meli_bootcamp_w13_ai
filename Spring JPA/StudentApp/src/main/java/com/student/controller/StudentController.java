package com.student.controller;

import com.student.dto.StudentRequestDto;
import com.student.dto.StudentResponseDto;
import com.student.model.Student;
import com.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public StudentResponseDto createStudent(@RequestBody StudentRequestDto dto){
        return studentService.createStudent(dto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/student/update")
    public StudentResponseDto updateStudent(@RequestBody StudentResponseDto dto){
        return studentService.updateStudent(dto);
    }

}
