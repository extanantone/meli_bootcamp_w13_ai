package com.ManejoExcepciones.Blog.mapper;

import com.ManejoExcepciones.Blog.dto.BlogCreateDTO;
import com.ManejoExcepciones.Blog.dto.BlogDTO;
import com.ManejoExcepciones.Blog.model.Blog;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BlogMapper {
    public static Blog blogDTOToBlog(BlogDTO blogDTO){
        Blog blog = new Blog();
        blog.setTitulo(blogDTO.getTitulo());
        blog.setAutor(blogDTO.getAutor());
        blog.setFecha(blogDTO.getFecha());
        return blog;
    }

    public static BlogDTO blogToBlogDTO(Blog blog){
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setTitulo(blog.getTitulo());
        blogDTO.setAutor(blog.getAutor());
        blogDTO.setFecha(blog.getFecha());

        return blogDTO;
    }

    public static Blog blogCreateDTOToBlog(BlogCreateDTO blogCreateDTO){
        Blog blog = new Blog();
        blog.setId(blogCreateDTO.getId());
        blog.setTitulo(blogCreateDTO.getTitulo());
        blog.setAutor(blogCreateDTO.getAutor());
        blog.setFecha(blogCreateDTO.getFecha());
        return blog;
    }
}
