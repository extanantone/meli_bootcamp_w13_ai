package com.MeLi.SocialMeli.mapper;

import com.MeLi.SocialMeli.DTO.CompradorDTO;
import com.MeLi.SocialMeli.DTO.DatosSeguidoresDTO;
import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Vendedor;

import java.util.List;

public class DatosSeguidoresMapper{
    public static DatosSeguidoresDTO dataVendedorToDatosSeguidoresDTO(Vendedor vendedor, List<CompradorDTO> seguidoresDatos){
        return new DatosSeguidoresDTO(vendedor.getId(), vendedor.getNombre(), seguidoresDatos);
    }
}
