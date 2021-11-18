package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.PostNotFoundException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IRepository<T> {

    void push(T newElement);

    Optional<T> findId(Integer id);

    List<T> findAll();

    void removeById(Integer id);

}
