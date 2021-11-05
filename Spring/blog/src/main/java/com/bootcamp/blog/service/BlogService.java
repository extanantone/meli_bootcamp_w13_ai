package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.exception.DuplicateBlogException;
import com.bootcamp.blog.exception.NotFoundException;
import com.bootcamp.blog.mapper.BlogMapper;
import com.bootcamp.blog.model.Blog;
import com.bootcamp.blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    IBlogRepository blogRepository;
    BlogMapper blogMapper;

    public BlogService(IBlogRepository blogRepository, BlogMapper blogMapper) {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
    }

    @Override
    public String newEntry(BlogDTO entry) {
        int id = blogRepository.newBlogEntry(blogMapper.blogDTOtoBlog(entry));
        if(id == -1){
            throw new DuplicateBlogException();
        }
        return "Post Creado ID: " + id;
    }

    @Override
    public BlogDTO getEntryById(int id) {
        Blog entry = blogRepository.getBlogEntry(id);
        if(entry == null){throw new NotFoundException();}
        return blogMapper.blogToBlogDTO(entry);
    }

    @Override
    public List<BlogDTO> getAllEntrys() {
        return blogRepository.getAllBlogEntry()
                .stream()
                .map(
                entry -> blogMapper.blogToBlogDTO(entry)
        ).collect(Collectors.toList());
    }



}
