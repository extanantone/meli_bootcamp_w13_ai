package com.meliBoot.manejoDeExcepciones.Blog.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class EntradaBlog {
    @Id
    @GeneratedValue()
    private long idBlog;

    private String tituloBlog;
    private String nombreAutor;
    private LocalDate fechaDePublicacion;

    public EntradaBlog(long idBlog, String tituloBlog, String nombreAutor, LocalDate fechaDePublicacion) {
        this.idBlog = idBlog;
        this.tituloBlog = tituloBlog;
        this.nombreAutor = nombreAutor;
        this.fechaDePublicacion = fechaDePublicacion;
    }
}
