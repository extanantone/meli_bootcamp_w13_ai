package com.ManejoExcepciones.Blog.repository;

import com.ManejoExcepciones.Blog.model.Blog;

import java.util.List;

public interface IBlogRepository {
    public int create(Blog blog);
    public Blog get(int id);
    public List<Blog> getAll();
}
