package com.example.bootcamp.demo.repository;

import com.example.bootcamp.demo.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{

private Map<Long,Blog> map = new HashMap<>();

    @Override
    public Blog nuevoBlog(Blog entradaBlog) {
        Long newId = entradaBlog.getId();
        this.map.put(newId, entradaBlog);
        return entradaBlog;
    }

    @Override
    public Blog getBlog(Long id) {
        return this.map.get(id);
    }


    @Override
    public List<Blog> getBlogs() {
        return this.map.entrySet().stream().map(e -> {
            e.getValue().setId(e.getKey());
            return e.getValue();
        }).collect(Collectors.toList());
    }
}
