package com.SocialMeli.Sprint1SocialMeli.Repository;

import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;

import com.SocialMeli.Sprint1SocialMeli.Model.Vendedor;

import java.util.List;

public interface ISocialMeliRepository {

    void follow(Integer id_Comprador, Integer id_vendedor); // Para US-01 POST
    void unFollow(Integer id_comprador, Integer id_vendedor); // Para US-07 POST

    void newPost (Publicacion publicacion); // Para US-05 POST

    Comprador getComprador(Integer id_comprador);
    Vendedor getVendedor(Integer id_vendedor);
    List<Publicacion> getPublicaciones();


}
