package com.example.updatestudent.controller;

import com.example.updatestudent.model.Student;
import com.example.updatestudent.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(Exception exception) {
        return new ResponseEntity<>("No such id could be found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<String> handleEntityExistsException(Exception e) {
        return  new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
    }

    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>("Estudiante agregado correctamente: " + student.getId().toString(), HttpStatus.CREATED);
    }

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(@RequestParam Long studentId) {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @DeleteMapping("/student")
    public ResponseEntity<Student> deleteStudent(@RequestParam Long studentId) {
        Student student = studentService.getStudentById(studentId);
        studentService.deteleStudent(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @PutMapping("/student")
    public ResponseEntity<Student> putStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

}
