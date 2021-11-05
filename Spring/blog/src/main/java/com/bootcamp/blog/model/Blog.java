package com.bootcamp.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Blog {
    int id;
    String titulo;
    String autor;
    String fechaPublicacion;
}
