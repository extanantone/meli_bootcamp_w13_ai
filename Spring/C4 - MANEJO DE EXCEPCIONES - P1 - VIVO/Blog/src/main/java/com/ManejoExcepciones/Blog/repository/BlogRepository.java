package com.ManejoExcepciones.Blog.repository;

import com.ManejoExcepciones.Blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository{
    int id = 0;
    HashMap<Integer, Blog> blogs = new HashMap<>();

    public BlogRepository(){
        blogs.put(id++, new Blog(id, "Blog 1", "Roger", LocalDate.of(2021, 11, 9)));
        blogs.put(id++, new Blog(id, "Blog 2", "Novak", LocalDate.of(2021, 10, 8)));
        blogs.put(id++, new Blog(id, "Blog 3", "Rafael", LocalDate.of(2021, 9, 7)));
    }

    @Override
    public int create(Blog blog) {
        int id = -1;
        if (blogs.get(blog.getId()) == null) {
            blogs.put(blog.getId(), blog);
            return blog.getId();
        }
        return id;
    }

    @Override
    public Blog get(int id) {
        return blogs.get(id);
    }

    @Override
    public List<Blog> getAll() {
        List<Blog> allBlogs = new ArrayList<>(this.blogs.values());
        return allBlogs;
    }
}
