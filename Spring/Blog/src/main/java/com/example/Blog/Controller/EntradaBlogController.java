package com.example.Blog.Controller;

import com.example.Blog.DTO.EntradaBlogDTO;
import com.example.Blog.Service.EntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EntradaBlogController implements EntradaBlogControllerI {

    @Autowired
    private EntradaBlogService service;

    public EntradaBlogDTO nuevoBlog(@RequestBody EntradaBlogDTO entradaBlogDTO){
        return service.crearNuevoBLog(entradaBlogDTO);
    }

    public EntradaBlogDTO getBlog(@RequestBody EntradaBlogDTO entradaBlogDTO){
        return service.getBlog(entradaBlogDTO.getId());
    }

    public List<EntradaBlogDTO> getBlogs(){
        return service.getBlogs();
    }
}
