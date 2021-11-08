package com.example.c4_manejo_excep_vivo_p1.repository;


import com.example.c4_manejo_excep_vivo_p1.model.EntradaBlog;

import java.util.List;
import java.util.Map;

public interface IBlogRepository
{
    List<EntradaBlog> getBlogs();

    Map<Long, EntradaBlog> getMap();

    void saveBlog(EntradaBlog entradaBlog);
}
