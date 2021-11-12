package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entitiy.Comprador;
import com.bootcamp.socialmeli.entitiy.Publicacion;
import com.bootcamp.socialmeli.entitiy.Vendedor;

import java.util.List;

public interface ISocialMeliRepository {

    boolean follow(Integer id_Comprador, Integer id_vendedor);
    boolean unFollow(Integer id_Comprador, Integer id_vendedor);
    List<Comprador> vendedorFollowers (Integer id_vendedor);
    List<Vendedor> compradorFollowed (Integer id_comprador);
    boolean newPost (Integer id_venderdor, Publicacion publicacion);
    List<Publicacion> postByVendedorOfComprador (Integer id_comprador);

    List<Comprador> vendedorFollowersOrderByName (Integer id_vendedor, String orden);
    List<Vendedor> compradorFollowedOrderByName (Integer id_comprador, String orden);

    List<Publicacion> postByVendedorOfCompradorOrderByDate (Integer id_comprador, String orden);

    Comprador getComprador(Integer id_comprador);
    Vendedor getVendedor(Integer id_vendedor);


}
