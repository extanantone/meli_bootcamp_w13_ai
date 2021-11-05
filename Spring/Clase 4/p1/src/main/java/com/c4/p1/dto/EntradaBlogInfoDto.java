package com.c4.p1.dto;

import com.c4.p1.model.EntradaBlog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class EntradaBlogInfoDto {
    String titulo;
    String autor;
    String fechaPublicacion;

    public EntradaBlogInfoDto(EntradaBlog entradaBlog){
        this.titulo = entradaBlog.getTitulo();
        this.autor = entradaBlog.getAutor();
        this.fechaPublicacion = entradaBlog.getFechaPublicacion().toString();
    }
}
