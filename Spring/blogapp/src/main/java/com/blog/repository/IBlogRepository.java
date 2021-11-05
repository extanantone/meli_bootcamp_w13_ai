package com.blog.repository;

import com.blog.model.BlogEntry;

public interface IBlogRepository {
    BlogEntry findById(int id);
    void addBlogEntry(BlogEntry entry);
}
