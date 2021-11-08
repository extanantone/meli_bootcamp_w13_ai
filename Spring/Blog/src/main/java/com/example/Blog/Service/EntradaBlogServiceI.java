package com.example.Blog.Service;

import com.example.Blog.DTO.EntradaBlogDTO;

import java.util.List;

public interface EntradaBlogServiceI {

    EntradaBlogDTO crearNuevoBLog(EntradaBlogDTO entradaBlogDTO);

    EntradaBlogDTO getBlog(Long id);

    List<EntradaBlogDTO> getBlogs();
}
