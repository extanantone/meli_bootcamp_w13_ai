package com.ManejoExcepciones.Blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Blog {
    private int id;
    private String titulo;
    private String autor;
    private LocalDate fecha;
}
