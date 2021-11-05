package com.bootcamp.excepciones.service;

import com.bootcamp.excepciones.exceptions.NotFoundException;
import com.bootcamp.excepciones.model.Book;
import com.bootcamp.excepciones.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    IBookRepository bookRepo;

    @Override
    public List<Book> traerTodos() {
        return bookRepo.traerTodos();
    }

    @Override
    public Book findById(Long id) {
        Book libroEncontrado = bookRepo.findById(id);
        if (libroEncontrado == null) {
//            throw new RuntimeException(); // excepcion propia de java
            throw new NotFoundException("El libro con la id: " + id + " no fue encontrado.");
        }
        return libroEncontrado;
    }
}
