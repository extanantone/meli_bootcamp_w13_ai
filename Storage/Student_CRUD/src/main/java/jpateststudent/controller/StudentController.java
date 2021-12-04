package jpateststudent.controller;

import jpateststudent.dto.StudentDTO;
import jpateststudent.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService stdService;

    public StudentController(StudentService stdService) {
        this.stdService = stdService;
    }

    @PostMapping("/student/add")
    ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO student){
        return new ResponseEntity<>(stdService.addStudent(student),HttpStatus.OK);
    }

    @GetMapping("/students")
    ResponseEntity<List> getStudents(){
        return new ResponseEntity<>(stdService.getStudents(),HttpStatus.OK);
    }

    @PutMapping("/student/update")
    ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO student){
        return new ResponseEntity<>(stdService.updateStudent(student),HttpStatus.OK);
    }

}
