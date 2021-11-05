package com.example.demo.controller;

import com.example.demo.dtos.EntradaBlogDTO;
import com.example.demo.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/v1/blogs")
public interface EntradaBlogControllerI {

    @PostMapping("/")
    EntradaBlogDTO nuevoBlog(@RequestBody EntradaBlogDTO entradaBlogDTO);

    @GetMapping("/{id}")
    EntradaBlogDTO getBlog(@PathVariable Long id);

    @GetMapping("/")
    List<EntradaBlogDTO> getBlogs();
}
