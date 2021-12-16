package com.example.ejemplo1.demo.controller;

import com.example.ejemplo1.demo.DTO.DTOStudent;
import com.example.ejemplo1.demo.model.Student;
import com.example.ejemplo1.demo.service.IStudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("student/add")
    public ResponseEntity<Long> createStudent (@RequestBody DTOStudent student){

        return studentService.createStudent(student);
    }

    @GetMapping("students")
    public ResponseEntity<List> getAllStudent (){
        return studentService.getAllStudent();
    }

    @PutMapping("student/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        System.out.println(student.getLastName());
        return studentService.updateStudent(student);
    }



}
