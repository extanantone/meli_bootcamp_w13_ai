package com.example.bootcamp.demo.mapper;

import com.example.bootcamp.demo.dto.EntradaBlogDTO;
import com.example.bootcamp.demo.model.Blog;
import org.springframework.stereotype.Component;

@Component
public class EntradaMapper {


    public Blog entradaBlogDTOToEntradaBlog(EntradaBlogDTO entradaBlogDTO){
        Blog entradaBlog = new Blog();
        entradaBlog.setId(entradaBlogDTO.getId());
        entradaBlog.setNombreAutor(entradaBlogDTO.getNombreAutor());
        entradaBlog.setFechaPublicacion(entradaBlogDTO.getFechaPublicacion());
        entradaBlog.setTituloBlog(entradaBlogDTO.getTituloBlog());
        return entradaBlog;
    }

    public EntradaBlogDTO entradaBlogToEntradaBlogDTO(Blog entradaBlog){
        EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO();
        entradaBlogDTO.setId(entradaBlog.getId());
        entradaBlogDTO.setNombreAutor(entradaBlog.getNombreAutor());
        entradaBlogDTO.setFechaPublicacion(entradaBlog.getFechaPublicacion());
        entradaBlogDTO.setTituloBlog(entradaBlog.getTituloBlog());
        return entradaBlogDTO;
    }





}
