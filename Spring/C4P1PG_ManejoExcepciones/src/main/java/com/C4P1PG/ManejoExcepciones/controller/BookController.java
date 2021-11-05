package com.C4P1PG.ManejoExcepciones.controller;

import com.C4P1PG.ManejoExcepciones.model.Book;
import com.C4P1PG.ManejoExcepciones.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/books")
    public List<Book> traerTodos(){
        return bookService.traerTodos();
    }

    @GetMapping("books/{id}")
    public Book findById(@PathVariable Long id){
        return bookService.findById(id);
    }
}
