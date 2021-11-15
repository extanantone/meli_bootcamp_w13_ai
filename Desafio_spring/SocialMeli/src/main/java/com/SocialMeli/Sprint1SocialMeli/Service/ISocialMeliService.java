package com.SocialMeli.Sprint1SocialMeli.Service;

import com.SocialMeli.Sprint1SocialMeli.DTO.*;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;

import java.util.ArrayList;
import java.util.List;


public interface ISocialMeliService {

    void validarComprador(Integer id_comprador); //Validaciones comun para metodos
    void validarVendedor(Integer id_vendedor); //Validaciones comun para metodos

    boolean serviceFollow(Integer id_Comprador, Integer id_vendedor); //US01
    SeguidoresDTO serviceVendedorFollowers (Integer id_vendedor); //US02

    ListadoSeguidoresDTO serviceVendedorListFollowers ( Integer id_vendedor); // US03
    ListadoSeguidosDTO serviceCompradorListFollowed(Integer id_comprador); // US04

    boolean serviceNewPost(PublicacionDTO publi) throws Exception; // US05

    List<Publicacion> listadoPublicacionTotal(); // Prueba

    List<ListadoPublicacionesDTO> listadoPublicaciones(int id_user); //US06


}
