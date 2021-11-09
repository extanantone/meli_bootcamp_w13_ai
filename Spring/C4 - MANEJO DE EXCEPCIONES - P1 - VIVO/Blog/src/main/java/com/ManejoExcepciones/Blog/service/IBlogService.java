package com.ManejoExcepciones.Blog.service;

import com.ManejoExcepciones.Blog.dto.BlogCreateDTO;
import com.ManejoExcepciones.Blog.dto.BlogDTO;

import java.util.List;

public interface IBlogService {
    public int create(BlogCreateDTO blog);
    public BlogDTO get(int id);
    public List<BlogDTO> getAll();
}
