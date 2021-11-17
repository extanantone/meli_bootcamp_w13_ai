package com.bootcamp.excepciones.service;

import com.bootcamp.excepciones.model.Book;

import java.util.List;

public interface IBookService {

    public List<Book> traerTodos();
    public Book findById(Long id);

}
