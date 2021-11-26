package com.example.socialmeli.repositories;

import com.example.socialmeli.model.Post;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {

    Optional<T> findById(Integer id);

    List<T> findAll();

    void push(Post newElement);

}
