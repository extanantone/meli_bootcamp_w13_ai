package com.bootcamp.blog.mapper;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.model.Blog;
import org.springframework.stereotype.Component;

@Component
public class BlogMapper {
    public Blog blogDTOtoBlog(BlogDTO entry) {
        return new Blog(entry.getId(), entry.getTitulo(), entry.getAutor(), entry.getFechaPublicacion());
    }

    public BlogDTO blogToBlogDTO(Blog entry) {
        return new BlogDTO(entry.getId(), entry.getTitulo(), entry.getAutor(), entry.getFechaPublicacion());
    }
}
