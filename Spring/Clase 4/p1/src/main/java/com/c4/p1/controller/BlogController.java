package com.c4.p1.controller;

import com.c4.p1.dto.EntradaBlogInfoDto;
import com.c4.p1.dto.EntradaBlogDto;
import com.c4.p1.dto.IdDto;
import com.c4.p1.exceptions.AlreadyExistsException;
import com.c4.p1.exceptions.NotFoundException;
import com.c4.p1.service.BlogService;
import com.c4.p1.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {

    IBlogService blogService;

    public BlogController(IBlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<IdDto> crearEntrada(@RequestBody EntradaBlogDto entradaBlogDto) throws AlreadyExistsException {
        return new ResponseEntity<>(new IdDto(blogService.insertarEntrada(entradaBlogDto)), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogInfoDto> consultarEntrada(@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(blogService.recuperarInfoEntrada(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDto>> consultarListadoEntradas(){
        return new ResponseEntity<>(blogService.recuperarListadoEntradas(), HttpStatus.OK);
    }
}
