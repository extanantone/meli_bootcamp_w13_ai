package com.example.blog.mapper;

import com.example.blog.dto.BlogDTO;
import com.example.blog.dto.BlogRegisterDTO;
import com.example.blog.entity.EntradaBlog;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BlogMapper {

    public BlogDTO blogToDTO(EntradaBlog blog){
        return new BlogDTO(blog.getTitle(),blog.getAutorName(),blog.getPublishDate());
    }

    public EntradaBlog dtoToBlog(BlogRegisterDTO dto, LocalDate publishDate){
        return new EntradaBlog(dto.getTitle(),dto.getAutorName(),publishDate);
    }
}
