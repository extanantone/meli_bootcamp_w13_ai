package com.example.Blog.Repository;

import com.example.Blog.Model.EntradaBlog;

import java.util.List;

public interface EntradaBlogRepositoryI {

    EntradaBlog nuevoBlog(EntradaBlog entrada);

    EntradaBlog findById(Long id);

    List<EntradaBlog> getBlogs();
}
