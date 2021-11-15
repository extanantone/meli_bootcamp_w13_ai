package com.SocialMeli.Sprint1SocialMeli.Repository;

import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Model.Usuario;
import com.SocialMeli.Sprint1SocialMeli.Model.Vendedor;

import java.util.List;

public interface ISocialMeliRepository {

    boolean follow(Integer id_Comprador, Integer id_vendedor);
    boolean unFollow(Integer id_Comprador, Integer id_vendedor);
    //List<Comprador> vendedorFollowers (Integer id_vendedor);
    //List<Vendedor> compradorFollowed (Integer id_comprador);
    boolean newPost (Publicacion publicacion);
    List<Publicacion> postByVendedorOfComprador (Integer id_comprador);

    List<Comprador> vendedorFollowersOrderByName (Integer id_vendedor, String orden);
    List<Vendedor> compradorFollowedOrderByName (Integer id_comprador, String orden);

    List<Publicacion> postByVendedorOfCompradorOrderByDate (Integer id_comprador, String orden);

    Comprador getComprador(Integer id_comprador);
    Vendedor getVendedor(Integer id_vendedor);
    List<Publicacion> getPublicaciones();


}
