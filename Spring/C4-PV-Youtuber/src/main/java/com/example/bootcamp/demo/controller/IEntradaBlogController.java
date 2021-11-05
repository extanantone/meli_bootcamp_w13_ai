package com.example.bootcamp.demo.controller;

import com.example.bootcamp.demo.dto.EntradaBlogDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IEntradaBlogController {

    @PostMapping("/blogs")
    EntradaBlogDTO nuevoBlog (@RequestBody EntradaBlogDTO entradaBlogDTO);

    @GetMapping("/blogs/{id}")
    EntradaBlogDTO getBlog (@PathVariable Long id);

    @GetMapping("/blogs")
    List<EntradaBlogDTO> getBlogs();


}
