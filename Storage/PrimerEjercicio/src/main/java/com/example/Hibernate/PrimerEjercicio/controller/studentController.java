package com.example.Hibernate.PrimerEjercicio.controller;

import com.example.Hibernate.PrimerEjercicio.DTOs.StudentDTO;
import com.example.Hibernate.PrimerEjercicio.DTOs.StudentResponseDTO;
import com.example.Hibernate.PrimerEjercicio.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class studentController {


    @Autowired
    IStudentService iStudentService;


    @PostMapping("/add")
    public StudentResponseDTO setStudent(@RequestBody StudentDTO studentDTO){

        return  iStudentService.setStudent(studentDTO);

    }

    @GetMapping("/studens")
    public List<StudentDTO> setStudent(){

        return  iStudentService.getStudents();

    }

    @PutMapping("/update")
    public StudentDTO putStudent(@RequestBody StudentDTO studentDTO){

        return  iStudentService.updateStudens(studentDTO);

    }

}
