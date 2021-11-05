package com.example.blog.controller;

import com.example.blog.dto.BlogDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @PostMapping("/blogs/blog")
    private ResponseEntity<String> crearEntrada(@RequestBody BlogDto blog){

        return new ResponseEntity<>("Ha sido creada la entrada correctamente, el ID es:", HttpStatus.OK);
    }
}
