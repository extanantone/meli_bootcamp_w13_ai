package com.SocialMeli.Sprint1SocialMeli.Service;

import com.SocialMeli.Sprint1SocialMeli.DTO.*;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;

import java.util.List;


public interface ISocialMeliService {

    boolean validarComprador(Integer id_comprador); //Validaciones comun para metodos
    boolean validarVendedor(Integer id_vendedor); //Validaciones comun para metodos

    void serviceFollow(Integer id_Comprador, Integer id_vendedor); //US-01
    CountSeguidoresDTO serviceCountVendedorFollowers(Integer id_vendedor); //US-02

    SeguidoresDTO serviceVendedorListFollowers (Integer id_vendedor, String Order); // US-03 y US-08
    SeguidosDTO serviceCompradorListFollowed(Integer id_comprador, String order); // US-04 y US-08

    void serviceNewPost(PublicacionDTO publi) throws Exception; // US05

    List<PublicacionesDTO> serviceListadoPublicaciones(int id_user, String Order); //US-06 u US-09
    void serviceUnFollow(Integer id_comprador, Integer id_vendedor); //US-07

    List<Publicacion> serviceListadoCompletoPublicaciones(); // Prueba



}
