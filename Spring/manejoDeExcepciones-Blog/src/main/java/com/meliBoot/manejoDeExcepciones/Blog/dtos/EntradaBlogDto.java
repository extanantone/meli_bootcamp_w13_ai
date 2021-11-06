package com.meliBoot.manejoDeExcepciones.Blog.dtos;

import com.meliBoot.manejoDeExcepciones.Blog.models.EntradaBlog;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EntradaBlogDto {
    @Id
    @GeneratedValue()
    private long idBlog;

    private String tituloBlog;
    private String nombreAutor;
    private LocalDate fechaDePublicacion;

    public EntradaBlogDto(EntradaBlog entradaBlog) {
        this.idBlog = entradaBlog.getIdBlog();
        this.tituloBlog = entradaBlog.getTituloBlog();
        this.nombreAutor = entradaBlog.getNombreAutor();
        this.fechaDePublicacion = entradaBlog.getFechaDePublicacion();
    }
}
