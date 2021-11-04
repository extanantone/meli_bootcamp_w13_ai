package com.bootcamp.ejemploAutowired.repository;

import com.bootcamp.ejemploAutowired.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    public List<Book> traerTodos(){
        List<Book> listaBooks = new ArrayList<>(); //simula una base de datos

        listaBooks.add(new Book(1L, "Martin Fierro", "José Hernandez"));
        listaBooks.add(new Book(2L, "El Principito", "Antoine de Saint-Exupéry"));

        return listaBooks;
    }
}
