package com.blog.controller;

import com.blog.dto.BlogEntryDto;
import com.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private IBlogService iBlogService;

    public BlogController(IBlogService iBlogService){
        this.iBlogService = iBlogService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BlogEntryDto getBlogEntryBy(@PathVariable int id){
        return iBlogService.getEntryById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addBlogEntry(@RequestBody BlogEntryDto dto){
        iBlogService.addBlogEntry(dto);
        return "id: "+dto.getId();
    }


}
