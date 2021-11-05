package com.bootcamp.excepciones.controller;

import com.bootcamp.excepciones.model.Book;
import com.bootcamp.excepciones.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

//    El autowired inyecta la dependencia
//    sin necesidad de crear un nuevo objeto

    @Autowired
    IBookService bookService;

    @GetMapping("/books")
    public List<Book> traerTodos() {
        return bookService.traerTodos();
    }

    @GetMapping("/books/{id}")
    public Book findById(@PathVariable Long id){
        return bookService.findById(id);
    }

}
