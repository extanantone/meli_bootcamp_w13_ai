package com.example.c4_manejo_excep_vivo_p1.service;

import com.example.c4_manejo_excep_vivo_p1.dto.EntradaBlogDTO;
import com.example.c4_manejo_excep_vivo_p1.model.EntradaBlog;

import java.util.List;

public interface IBlogService
{
    List<EntradaBlogDTO> getBlogs();

    EntradaBlogDTO getBlog(Long id);

    EntradaBlogDTO createBlog(EntradaBlogDTO entradaBlogDTO);
}
