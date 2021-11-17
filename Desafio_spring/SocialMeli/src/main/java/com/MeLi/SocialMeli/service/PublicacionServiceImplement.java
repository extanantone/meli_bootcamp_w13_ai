package com.MeLi.SocialMeli.service;

import com.MeLi.SocialMeli.DTO.PubVendedoresDTO;
import com.MeLi.SocialMeli.DTO.PublicacionDTO;
import com.MeLi.SocialMeli.exception.NotFoundCompradorException;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.exception.NotPubException;
import com.MeLi.SocialMeli.model.Publicacion;

import java.util.HashMap;
import java.util.List;

public interface PublicacionServiceImplement {
    Publicacion addNewPub(PublicacionDTO pubDTO) throws NotPubException;
    PubVendedoresDTO obtenerPublicaciones(int idUser, String order) throws NotFoundVendedorException, NotFoundCompradorException;
}
