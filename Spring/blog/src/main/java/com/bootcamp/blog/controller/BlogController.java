package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.mapper.BlogMapper;
import com.bootcamp.blog.service.BlogService;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<String> postEntryBlog(@RequestBody BlogDTO entry){
        return new ResponseEntity<>(blogService.newEntry(entry) , HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getBlogbyId(@PathVariable int id){
        return new ResponseEntity<>(blogService.getEntryById(id) , HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getBlogs(){
        return new ResponseEntity<>(blogService.getAllEntrys() , HttpStatus.OK);
    }

}
