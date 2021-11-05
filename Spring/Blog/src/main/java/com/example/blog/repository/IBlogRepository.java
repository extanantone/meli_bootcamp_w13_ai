package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;

import java.time.LocalDate;
import java.util.List;

public interface IBlogRepository {
    Long addBlog(EntradaBlog blog);
    EntradaBlog findBlog(Long id);
    List<EntradaBlog> getAllBlogs();
}
