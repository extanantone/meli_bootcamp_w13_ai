package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.dto.EntradaCreadaDTO;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BlogController {

    private IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> crearEntrada(@RequestBody EntradaBlogDTO entrada){
        Integer id = this.blogService.crearEntrada(entrada);
        return new ResponseEntity<>(new EntradaCreadaDTO("Entrada creada correctamente.", id), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getInfoEntrada(@PathVariable Integer id){
        return new ResponseEntity<>(this.blogService.getEntrada(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> listarEntradas(){
        return new ResponseEntity<>(this.blogService.getAllEntradas(), HttpStatus.OK);
    }

}
