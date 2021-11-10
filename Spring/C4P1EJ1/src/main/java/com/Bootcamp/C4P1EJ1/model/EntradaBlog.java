package com.Bootcamp.C4P1EJ1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private int idBlog;
    private String tituloBlog;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
