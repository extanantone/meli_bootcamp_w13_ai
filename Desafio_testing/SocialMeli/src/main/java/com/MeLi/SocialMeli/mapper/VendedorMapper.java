package com.MeLi.SocialMeli.mapper;

import com.MeLi.SocialMeli.DTO.CompradorDTO;
import com.MeLi.SocialMeli.DTO.VendedorDTO;
import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Vendedor;

import java.util.List;

public class VendedorMapper {
    public static VendedorDTO vendedorToVendedorDTO(Vendedor vendedor){
        return new VendedorDTO(vendedor.getId(),vendedor.getNombre());
    }
}
