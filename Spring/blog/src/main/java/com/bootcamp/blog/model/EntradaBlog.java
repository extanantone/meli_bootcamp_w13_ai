package com.bootcamp.blog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EntradaBlog {

    private Integer id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    public EntradaBlog(Integer id, String titulo, String autor, LocalDate fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
