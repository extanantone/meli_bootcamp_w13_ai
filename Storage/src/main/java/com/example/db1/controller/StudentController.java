package com.example.db1.controller;

import com.example.db1.dto.StudentDto;
import com.example.db1.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public ResponseEntity<String> createStudent (@RequestBody StudentDto student){

        studentService.createStudent(student);

        return new ResponseEntity<>("creado", HttpStatus.OK);


    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(),HttpStatus.OK);
    }

    @PutMapping("/student/update")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.updateStudent(studentDto),HttpStatus.OK);
    }

}
