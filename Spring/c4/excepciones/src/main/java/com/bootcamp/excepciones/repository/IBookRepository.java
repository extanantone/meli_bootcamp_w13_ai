package com.bootcamp.excepciones.repository;
import com.bootcamp.excepciones.model.Book;

import java.util.List;

public interface IBookRepository {
    public List<Book> traerTodos();
    public Book findById(Long id);
}
