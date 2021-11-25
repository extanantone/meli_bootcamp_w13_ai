package com.MeLi.SocialMeli.service;

import com.MeLi.SocialMeli.DTO.DatosSeguidoresDTO;
import com.MeLi.SocialMeli.DTO.SeguidoresDTO;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;

public interface VendedorServiceImplement {

    SeguidoresDTO contarSeguidores(int idVendedor) throws NotFoundVendedorException;

    DatosSeguidoresDTO getInfoSeguidores(int idVendedor, String order) throws NotFoundVendedorException;
}
