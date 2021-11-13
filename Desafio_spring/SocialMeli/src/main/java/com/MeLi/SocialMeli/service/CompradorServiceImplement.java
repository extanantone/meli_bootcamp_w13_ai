package com.MeLi.SocialMeli.service;

import com.MeLi.SocialMeli.DTO.DatosSeguidoresDTO;
import com.MeLi.SocialMeli.DTO.InfoSeguidosDTO;
import com.MeLi.SocialMeli.DTO.SeguimientoDTO;
import com.MeLi.SocialMeli.DTO.VendedorDTO;
import com.MeLi.SocialMeli.exception.NotFoundCompradorException;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.model.Comprador;

import java.util.List;

public interface CompradorServiceImplement {
    SeguimientoDTO seguir(int idSeguidor, int idSeguido) throws NotFoundCompradorException, NotFoundVendedorException;

    InfoSeguidosDTO verSeguidos(int idComprador) throws NotFoundCompradorException, NotFoundVendedorException;

    int getCantidadSeguidos();

    void anadirSeguido(Comprador comprador);
}
