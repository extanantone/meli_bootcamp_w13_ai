package com.example.blog.controller;

import com.example.blog.dto.BlogDTO;
import com.example.blog.dto.BlogRegisterDTO;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable Long id){
        return ResponseEntity.ok().body(blogService.findBlog(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getAllBlogs(){
        return ResponseEntity.ok().body(blogService.getAllBlogs());
    }

    @PostMapping("/blog")
    public ResponseEntity<Long> createBlog(@RequestBody BlogRegisterDTO blog){
        return ResponseEntity.ok().body(blogService.addBlog(blog));
    }
}
