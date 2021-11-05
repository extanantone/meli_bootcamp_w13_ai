package com.blog.service;

import com.blog.dto.BlogEntryDto;
import com.blog.exception.ExistException;
import com.blog.exception.NotFoundEntryException;
import com.blog.mapper.BlogEntryDtoMapper;
import com.blog.mapper.IBlogEntryDtoMapper;
import com.blog.model.BlogEntry;
import com.blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService{

    private IBlogRepository iBlogRepository;

    private IBlogEntryDtoMapper iBlogEntryDtoMapper;



    public  BlogService(IBlogRepository iBlogRepository, IBlogEntryDtoMapper iBlogEntryDtoMapper){
        this.iBlogRepository = iBlogRepository;
        this.iBlogEntryDtoMapper = iBlogEntryDtoMapper;
    }

    @Override
    public BlogEntryDto getEntryById(int id) {
        BlogEntry dto =  iBlogRepository.findById(id);
        if(dto==null)
            throw new NotFoundEntryException(NotFoundEntryException.NOEXISTRESOURCE);
        return iBlogEntryDtoMapper.getBlogEntryDto(dto);
    }

    @Override
    public void addBlogEntry(BlogEntryDto entry) {
        if(iBlogRepository.findById(entry.getId())!=null)
            throw new ExistException(ExistException.EXISTRESOURCE);
        iBlogRepository.addBlogEntry(iBlogEntryDtoMapper.getBlogEntry(entry));
    }
}
