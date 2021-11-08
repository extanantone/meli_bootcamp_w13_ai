package com.bootcamp.excepciones.repository;

import com.bootcamp.excepciones.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements IBookRepository{

    List<Book> listaBooks = new ArrayList<>(){{
        add(new Book(1L, "Martin Fierro", "José Hernandez"));
        add(new Book(2L, "Sherlock Holmes", "Arthur Conan Doyle"));
    }};

    @Override
    public List<Book> traerTodos() {
        return listaBooks;
    }

    @Override
    public Book findById(Long id) {
        for (Book b : listaBooks) {
            if(b.getId().equals(id)){
                return b;
            }
        }
        return null;
    }
}
