package com.example.Blog.Controller;

import com.example.Blog.DTO.EntradaBlogDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/v1/blogs")
public interface EntradaBlogControllerI {

    @PostMapping("/")
    EntradaBlogDTO nuevoBlog(@RequestBody EntradaBlogDTO entradaBlogDTO);

    @GetMapping("/buscar")
    EntradaBlogDTO getBlog(@RequestBody EntradaBlogDTO entradaBlogDTO);

    @GetMapping("/")
    List<EntradaBlogDTO> getBlogs();
}
