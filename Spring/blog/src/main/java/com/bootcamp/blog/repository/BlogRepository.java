package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository{

    HashMap<Integer, Blog> blogMap = new HashMap<>();

    @Override
    public int newBlogEntry(Blog entry) {
        int id = entry.getId();
        if(blogMap.containsKey(id)) {
            return -1;
        }
        blogMap.put(id, entry);
        return id;
    }

    @Override
    public Blog getBlogEntry(int id) {
        if(blogMap.containsKey(id)) {
            return blogMap.get(id);
        }
        return null;
    }

    @Override
    public List<Blog> getAllBlogEntry() {
        return new ArrayList<Blog>(blogMap.values());
    }
}
