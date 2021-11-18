package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.PostNotFoundException;
import com.example.socialmeli.exceptions.UserNotFoundException;

import java.util.List;

public interface IRepository<T> {

    List<T> loadRepository();
    void push(T newElement);
    T getById(Integer id) throws UserNotFoundException, PostNotFoundException;
    List<T> getAll();
    void removeById(Integer id);

}
