package com.bootcamp.implementacionDI.controller;

import com.bootcamp.implementacionDI.model.Book;
import com.bootcamp.implementacionDI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

//    El autowired inyecta la dependencia
//    sin necesidad de crear un nuevo objeto
    @Autowired
    BookRepository repository;

    @GetMapping("/books")
    public List<Book> traerTodos() {
        return repository.traerTodos();
    }
}
