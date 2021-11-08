package com.example.Blog.Controller;

import com.example.Blog.DTO.EntradaBlogDTO;
import com.example.Blog.Service.EntradaBlogServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    EntradaBlogServiceI service;

    @GetMapping("/user")
    public EntradaBlogDTO demo(){
        return service.getBlog(0L);
    }
}
