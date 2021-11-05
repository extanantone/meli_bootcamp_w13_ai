package com.example.bootcamp.demo.repository;

import com.example.bootcamp.demo.dto.EntradaBlogDTO;
import com.example.bootcamp.demo.model.Blog;

import java.util.List;

public interface IEntradaBlogRepository {

    public Blog nuevoBlog(Blog entradaBlog);
    public Blog getBlog (Long id);
    public List<Blog> getBlogs();

}
