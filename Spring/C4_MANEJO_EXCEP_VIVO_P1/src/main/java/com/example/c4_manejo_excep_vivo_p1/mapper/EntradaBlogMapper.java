package com.example.c4_manejo_excep_vivo_p1.mapper;

import com.example.c4_manejo_excep_vivo_p1.dto.EntradaBlogDTO;
import com.example.c4_manejo_excep_vivo_p1.model.EntradaBlog;
import org.springframework.stereotype.Component;

@Component
public class EntradaBlogMapper
{
    public EntradaBlog entradaBlogDTOToEntradaBlog(EntradaBlogDTO entradaBlogDTO)
    {
        EntradaBlog entradaBlog = new EntradaBlog();
        entradaBlog.setId(entradaBlogDTO.getId());
        entradaBlog.setAuthorName(entradaBlogDTO.getAuthorName());
        entradaBlog.setPubDate(entradaBlogDTO.getPubDate());
        entradaBlog.setTitle(entradaBlogDTO.getTitle());
        return entradaBlog;
    }

    public EntradaBlogDTO entradaBlogToEntradaBlogDTO(EntradaBlog entradaBlog)
    {
        EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO();
        entradaBlogDTO.setAuthorName(entradaBlog.getAuthorName());
        entradaBlogDTO.setTitle(entradaBlog.getTitle());
        entradaBlogDTO.setId(entradaBlog.getId());
        entradaBlogDTO.setPubDate(entradaBlog.getPubDate());
        return entradaBlogDTO;
    }
}
