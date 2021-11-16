package com.SocialMeli.Sprint1SocialMeli.Service;

import com.SocialMeli.Sprint1SocialMeli.DTO.*;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;

import java.util.ArrayList;
import java.util.List;


public interface ISocialMeliService {

    void validarComprador(Integer id_comprador); //Validaciones comun para metodos
    void validarVendedor(Integer id_vendedor); //Validaciones comun para metodos

    boolean serviceFollow(Integer id_Comprador, Integer id_vendedor); //US-01
    SeguidoresDTO serviceVendedorFollowers (Integer id_vendedor); //US-02

    ListadoSeguidoresDTO serviceVendedorListFollowers ( Integer id_vendedor, String Order); // US-03 y US-08
    ListadoSeguidosDTO serviceCompradorListFollowed(Integer id_comprador, String order); // US-04 y US-08

    boolean serviceNewPost(PublicacionDTO publi) throws Exception; // US05

    List<Publicacion> listadoPublicacionTotal(); // Prueba

    List<ListadoPublicacionesDTO> listadoPublicaciones(int id_user, String Order); //US-06 u US-09
    boolean serviceUnFollow(Integer id_comprador, Integer id_vendedor); //US-07



}
