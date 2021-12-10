package com.ejercicio.studentJPA.controller;
import com.ejercicio.studentJPA.dto.StudentDTO;
import com.ejercicio.studentJPA.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public ResponseEntity<?> addStudent(@RequestBody StudentDTO student){
        return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<?> listStudents(){
        return new ResponseEntity<>(studentService.listStudents(),HttpStatus.OK);
    }

    @PostMapping("/student/update")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO student){
        return new ResponseEntity<>(studentService.updateStudent(student),HttpStatus.OK);
    }


}
