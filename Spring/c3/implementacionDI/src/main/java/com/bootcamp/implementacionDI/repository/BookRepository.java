package com.bootcamp.implementacionDI.repository;

import com.bootcamp.implementacionDI.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    public List<Book> traerTodos() {
        List<Book> listaBooks = new ArrayList<>();
        listaBooks.add(new Book(1L, "¿Como programar en java?", "Luisina de paula"));
        listaBooks.add(new Book(2L, "Servidores: ¿como administrarlos?", "Gabriel guismin"));

        return listaBooks;
    }
}
