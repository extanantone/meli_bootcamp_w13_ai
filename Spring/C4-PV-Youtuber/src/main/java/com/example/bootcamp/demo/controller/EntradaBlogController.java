package com.example.bootcamp.demo.controller;

import com.example.bootcamp.demo.dto.EntradaBlogDTO;
import com.example.bootcamp.demo.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntradaBlogController implements IEntradaBlogController{

@Autowired
    IEntradaBlogService entradaBlogService;


    @Override
    public EntradaBlogDTO nuevoBlog(EntradaBlogDTO entradaBlogDTO) {

        return entradaBlogService.nuevoBlog(entradaBlogDTO);
    }

    @Override
    public EntradaBlogDTO getBlog(Long id) {
        return entradaBlogService.getBlog(id);
    }

    @Override
    public List<EntradaBlogDTO> getBlogs() {
        return entradaBlogService.getBlogs();
    }


}
