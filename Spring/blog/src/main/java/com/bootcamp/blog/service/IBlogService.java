package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogDTO;

import java.util.List;

public interface IBlogService {
    public String newEntry(BlogDTO entry);
    public BlogDTO getEntryById(int id);
    public List<BlogDTO> getAllEntrys();
}
