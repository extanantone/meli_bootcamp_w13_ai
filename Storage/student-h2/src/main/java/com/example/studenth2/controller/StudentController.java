package com.example.studenth2.controller;

import com.example.studenth2.dto.StudentCreationDTO;
import com.example.studenth2.dto.StudentDTO;
import com.example.studenth2.dto.StudentQualificationsDTO;
import com.example.studenth2.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    ResponseEntity<StudentDTO> addStudent(@RequestBody StudentCreationDTO student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<StudentQualificationsDTO> updateStudent(@RequestBody StudentQualificationsDTO student) {
        return new ResponseEntity<>(studentService.update(student), HttpStatus.OK);
    }
}
