package com.bootcamp.excepciones.service;

import com.bootcamp.excepciones.exceptions.NotFoundException;
import com.bootcamp.excepciones.model.Book;
import com.bootcamp.excepciones.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    BookRepository bookRepo;

    @Override
    public List<Book> traerTodos() {
        return bookRepo.traerTodos();
    }

    @Override
    public Book findById(Long id) {
        Book libroEncontrado = bookRepo.findById(id);
        if(libroEncontrado == null){
            throw new NotFoundException("El libro con id: " + id + " no fue encontrado.");
        }
        return libroEncontrado;
    }
}
