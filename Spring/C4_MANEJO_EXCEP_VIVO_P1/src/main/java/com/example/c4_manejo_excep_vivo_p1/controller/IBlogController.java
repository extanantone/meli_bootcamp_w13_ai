package com.example.c4_manejo_excep_vivo_p1.controller;

import com.example.c4_manejo_excep_vivo_p1.dto.EntradaBlogDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/blogs")
public interface IBlogController
{
    @PostMapping("")
    EntradaBlogDTO createBlog(@RequestBody EntradaBlogDTO entradaBlogDTO);

    @GetMapping("/{id}")
    EntradaBlogDTO getBlog(@PathVariable Long id);

    @GetMapping
    List<EntradaBlogDTO> getBlogs();
}
