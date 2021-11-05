package com.bootcamp.excepciones.repository;

import com.bootcamp.excepciones.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements IBookRepository{

    List<Book> listaBooks = new ArrayList<Book>() {{
        add(new Book(1L, "¿Como programar en java?", "Luisina de paula"));
        add(new Book(2L, "Servidores: ¿como administrarlos?", "Gabriel guismin"));
    }};

    @Override
    public List<Book> traerTodos() {
        return listaBooks;
    }

    @Override
    public Book findById(Long id) {
        for(Book book : listaBooks){
            if(book.getId().equals(id)){
                return book;
            }
        }
        return null;
    }
}
