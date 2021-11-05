package com.example.demo.repository;

import com.example.demo.model.EntradaBlog;

import java.util.List;

public interface EntradaBlogRepositoryI {

    EntradaBlog nuevoBlog(EntradaBlog entrada);

    EntradaBlog findById(Long id);

    List<EntradaBlog> getBlogs();
}
