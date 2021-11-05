package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{

    private Long counter;
    private Map<Long,EntradaBlog> db;

    public BlogRepositoryImpl() {
        this.counter = 0L;
        this.db = new HashMap<>();
    }

    @Override
    public Long addBlog(EntradaBlog blog) {
        Long nextID = this.counter;
        this.counter++;
        this.db.put(nextID, blog);
        return nextID;
    }

    @Override
    public EntradaBlog findBlog(Long id) {
        return this.db.get(id);
    }

    @Override
    public List<EntradaBlog> getAllBlogs() {
        return new ArrayList<>(this.db.values());
    }
}
