package com.meli.probandojpa.controller;

import com.meli.probandojpa.dto.StudentDTO;
import com.meli.probandojpa.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //TEST
    /*{
    "id": "4",
    "dni": "39888889",
    "name": "Marco",
    "last_name": "Avila"
}*/

    @PostMapping("student/add")
    public ResponseEntity<Long> addStudent(@RequestBody StudentDTO studentDTO) {


        return new ResponseEntity(studentService.addStudent(studentDTO), HttpStatus.OK);
    }
}
