package bds.ormjpa.controller;

import bds.ormjpa.dtos.StudentDTO;
import bds.ormjpa.dtos.StudentIdDTO;
import bds.ormjpa.model.Student;
import bds.ormjpa.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/students/add")
    public ResponseEntity<StudentIdDTO> addStudent(@RequestBody StudentDTO student){
        return ResponseEntity.ok(studentService.addStudent(student));
    }

}
