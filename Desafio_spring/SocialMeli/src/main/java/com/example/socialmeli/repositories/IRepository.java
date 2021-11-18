package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.PostNotFoundException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.model.Post;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {

    List<T> loadRepository();
    void push(T newElement);
    Optional<T> getById(Integer id);
    List<T> getAll();
    void removeById(Integer id);

}
