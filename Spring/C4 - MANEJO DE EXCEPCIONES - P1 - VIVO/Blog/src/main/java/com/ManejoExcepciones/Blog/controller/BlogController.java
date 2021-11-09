package com.ManejoExcepciones.Blog.controller;

import com.ManejoExcepciones.Blog.dto.BlogCreateDTO;
import com.ManejoExcepciones.Blog.dto.BlogDTO;
import com.ManejoExcepciones.Blog.service.IBlogService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> create(@RequestBody BlogCreateDTO blogDTO){
        return new ResponseEntity<>(blogService.create(blogDTO), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        return new ResponseEntity<>(blogService.get(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK);
    }
}
