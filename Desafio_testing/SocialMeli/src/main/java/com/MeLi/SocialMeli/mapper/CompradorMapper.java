package com.MeLi.SocialMeli.mapper;

import com.MeLi.SocialMeli.DTO.CompradorDTO;
import com.MeLi.SocialMeli.DTO.SeguimientoDTO;
import com.MeLi.SocialMeli.model.Comprador;

public class CompradorMapper {

    public static CompradorDTO compradorToCompradorDTO(Comprador comprador){
        return new CompradorDTO(comprador.getId(),comprador.getNombre());
    }
}
