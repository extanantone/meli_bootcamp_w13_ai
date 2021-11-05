package com.C4P1PG.ManejoExcepciones.service;

import com.C4P1PG.ManejoExcepciones.model.Book;

import java.util.List;

public interface IBookService {
    public List<Book> traerTodos();
    public Book findById(Long id);
}
