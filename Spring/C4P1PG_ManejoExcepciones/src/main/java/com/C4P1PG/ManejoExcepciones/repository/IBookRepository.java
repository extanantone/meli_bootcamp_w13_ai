package com.C4P1PG.ManejoExcepciones.repository;

import com.C4P1PG.ManejoExcepciones.model.Book;

import java.util.List;

public interface IBookRepository {

    public List<Book> traerTodos();
    public Book findById(Long id);
}
