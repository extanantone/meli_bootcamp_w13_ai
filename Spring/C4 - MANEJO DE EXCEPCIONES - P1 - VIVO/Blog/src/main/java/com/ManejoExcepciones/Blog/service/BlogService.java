package com.ManejoExcepciones.Blog.service;

import com.ManejoExcepciones.Blog.mapper.BlogMapper;
import com.ManejoExcepciones.Blog.dto.BlogCreateDTO;
import com.ManejoExcepciones.Blog.dto.BlogDTO;
import com.ManejoExcepciones.Blog.exception.AlreadyExistsException;
import com.ManejoExcepciones.Blog.exception.BadRequestCreateBlogException;
import com.ManejoExcepciones.Blog.exception.NotFoundException;
import com.ManejoExcepciones.Blog.model.Blog;
import com.ManejoExcepciones.Blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public int create(BlogCreateDTO blog) {
        if (blog.getId() < 0){
            throw new BadRequestCreateBlogException("No se puede crear blogs con id negativos");
        }
        int id = blogRepository.create(BlogMapper.blogCreateDTOToBlog(blog));
        if (id == -1) {
            throw new AlreadyExistsException("Blog con id "+blog.getId()+" ya creado");
        }
        return id;
    }

    @Override
    public BlogDTO get(int id) {
        Blog blog = blogRepository.get(id);
        if (blog == null) {
            throw new NotFoundException("Blog con id "+id+" no encontrado");
        }
        return BlogMapper.blogToBlogDTO(blog);
    }

    @Override
    public List<BlogDTO> getAll() {
        List<Blog> blogs = blogRepository.getAll();
        return blogs.stream().map(BlogMapper::blogToBlogDTO).collect(Collectors.toList());
    }
}
