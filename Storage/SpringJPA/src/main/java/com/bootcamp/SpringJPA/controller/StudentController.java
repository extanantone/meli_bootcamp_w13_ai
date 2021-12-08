package com.bootcamp.SpringJPA.controller;

import com.bootcamp.SpringJPA.dto.CalificationDTO;
import com.bootcamp.SpringJPA.dto.StudentDTO;
import com.bootcamp.SpringJPA.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    private IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO newStudent){
        return new ResponseEntity<>(this.studentService.createStudent(newStudent), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(){
        return new ResponseEntity<>(this.studentService.getStudents(), HttpStatus.OK);
    }

    @PutMapping("/student/update")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO student){
        return new ResponseEntity<>(this.studentService.updateStudent(student), HttpStatus.OK);
    }

    @DeleteMapping("/student/delete/{student_id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("student_id") Long studentId){
        return new ResponseEntity<>(this.studentService.deleteStudent(studentId), HttpStatus.OK);
    }

    //agrega nuevas calificaciones a un student
    @PostMapping("/califications/add")
    public ResponseEntity<?> createStudent(@RequestBody CalificationDTO newCalification){
        return new ResponseEntity<>(this.studentService.addCalification(newCalification), HttpStatus.OK);
    }

    //Obtiene todas las calificaciones de un estudiante
    @GetMapping("/califications/{student_id}")
    public ResponseEntity<?> getCalifications(@PathVariable("student_id") Long studentId){
        return new ResponseEntity<>(this.studentService.getCalifications(studentId), HttpStatus.OK);
    }
}
