package com.example.blog.service;

import com.example.blog.dto.BlogDTO;
import com.example.blog.dto.BlogRegisterDTO;

import java.util.List;

public interface IBlogService {
    Long addBlog(BlogRegisterDTO blog);
    BlogDTO findBlog(Long id);
    List<BlogDTO> getAllBlogs();
}
