package com.MeLi.SocialMeli.mapper;

import com.MeLi.SocialMeli.DTO.InfoSeguidosDTO;
import com.MeLi.SocialMeli.DTO.VendedorDTO;
import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Vendedor;

import java.util.List;

public class InfoSeguidosMapper {
    public static InfoSeguidosDTO infoSeguidosToInfoSeguidosDTO(Comprador comprador, List<VendedorDTO> listaSeguidos){
        return new InfoSeguidosDTO(comprador.getId(),comprador.getNombre(),listaSeguidos);
    }
}
