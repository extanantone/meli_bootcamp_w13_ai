package com.bootcamp.excepciones.repository;

import com.bootcamp.excepciones.model.Book;

import java.util.List;

public interface IBookRepository {

    public List<Book> traerTodos(); //trae todos los libros

    public Book findById(Long id); //trae un libro en particular
}
