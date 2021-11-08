package com.bootcamp.excepciones.service;

import com.bootcamp.excepciones.model.Book;

import java.util.List;

public interface IBookService {

    public List<Book> traerTodos(); //trae todos los libros

    public Book findById(Long id); //trae un libro en particular

}
