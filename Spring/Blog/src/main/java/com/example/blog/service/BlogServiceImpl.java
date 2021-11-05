package com.example.blog.service;

import com.example.blog.dto.BlogDTO;
import com.example.blog.dto.BlogRegisterDTO;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.exception.NotFoundException;
import com.example.blog.mapper.BlogMapper;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Long addBlog(BlogRegisterDTO blog) {
        return blogRepository.addBlog(blogMapper.dtoToBlog(blog,LocalDate.now()));
    }

    @Override
    public BlogDTO findBlog(Long id) {
        EntradaBlog blog = blogRepository.findBlog(id);
        if(blog == null) throw new NotFoundException("No se encontro el blog con ID " + String.valueOf(id));
        return blogMapper.blogToDTO(blog);
    }

    @Override
    public List<BlogDTO> getAllBlogs() {
        List<EntradaBlog> blogs = blogRepository.getAllBlogs();
        List<BlogDTO> response = new ArrayList<>();
        blogs.forEach(e -> response.add(blogMapper.blogToDTO(e)));
        return response;
    }
}
