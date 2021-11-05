package com.blog.service;

import com.blog.dto.BlogEntryDto;

public interface IBlogService {
    BlogEntryDto getEntryById(int id);
    void addBlogEntry(BlogEntryDto entry);
}
