package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.Blog;

import java.util.List;

public interface IBlogRepository {
    public int newBlogEntry(Blog entry);
    public Blog getBlogEntry(int id);
    public List<Blog> getAllBlogEntry();
}
