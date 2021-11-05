package com.c4.p1.dto;

import com.c4.p1.model.EntradaBlog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class EntradaBlogDto {
    Integer id;
    String titulo;
    String autor;
    String fechaPublicacion;

    public EntradaBlogDto(EntradaBlog entradaBlog){
        this.id = entradaBlog.getId();
        this.titulo = entradaBlog.getTitulo();
        this.autor = entradaBlog.getAutor();
        this.fechaPublicacion = entradaBlog.getFechaPublicacion().toString();
    }
}
