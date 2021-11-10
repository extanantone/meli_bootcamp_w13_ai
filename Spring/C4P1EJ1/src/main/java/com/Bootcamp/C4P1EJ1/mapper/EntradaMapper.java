package com.Bootcamp.C4P1EJ1.mapper;

import com.Bootcamp.C4P1EJ1.dto.EntradaBlogDTO;
import com.Bootcamp.C4P1EJ1.model.EntradaBlog;
import org.springframework.stereotype.Component;

@Component
public class EntradaMapper {
    public EntradaBlog entradaBlogDTOAEntradaBlog(EntradaBlogDTO entradaBlogDTO) {
        EntradaBlog entradaBlog = new EntradaBlog();
        entradaBlog.setIdBlog(entradaBlogDTO.getIdBlog());
        entradaBlog.setTituloBlog(entradaBlogDTO.getTituloBlog());
        entradaBlog.setNombreAutor(entradaBlogDTO.getNombreAutor());
        entradaBlog.setFechaPublicacion(entradaBlogDTO.getFechaPublicacion());
        return entradaBlog;
    }

    public EntradaBlogDTO entradaBlogAEntradaBlogDTO(EntradaBlog entradaBlog) {
        EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO();
        entradaBlogDTO.setIdBlog(entradaBlog.getIdBlog());
        entradaBlogDTO.setTituloBlog(entradaBlog.getTituloBlog());
        entradaBlogDTO.setNombreAutor(entradaBlog.getNombreAutor());
        entradaBlogDTO.setFechaPublicacion(entradaBlog.getFechaPublicacion());
        return entradaBlogDTO;
    }
}
