package com.MeLi.SocialMeli.mapper;

import com.MeLi.SocialMeli.DTO.CompradorDTO;
import com.MeLi.SocialMeli.DTO.DatosSeguidoresDTO;
import com.MeLi.SocialMeli.DTO.SeguidoresDTO;
import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Vendedor;

public class SeguidoresMapper {

    public static SeguidoresDTO seguidoresToSeguidoresDTO(Vendedor vendedor){
        return new SeguidoresDTO(vendedor.getId(),vendedor.getNombre(),vendedor.getCantSeguidores());
    }
}
