package com.example.c4_manejo_excep_vivo_p1.controller;

import com.example.c4_manejo_excep_vivo_p1.dto.EntradaBlogDTO;
import com.example.c4_manejo_excep_vivo_p1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController implements  IBlogController
{
    @Autowired
    IBlogService blogService;

    @Override
    public List<EntradaBlogDTO> getBlogs()
    {
        return blogService.getBlogs();
    }

    @Override
    public EntradaBlogDTO getBlog(Long id)
    {
        return blogService.getBlog(id);
    }

    @Override
    public EntradaBlogDTO createBlog(EntradaBlogDTO entradaBlogDTO)
    {
        return blogService.createBlog(entradaBlogDTO);
    }
}
