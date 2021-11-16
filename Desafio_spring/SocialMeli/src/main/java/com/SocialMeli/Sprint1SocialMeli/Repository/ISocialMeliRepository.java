package com.SocialMeli.Sprint1SocialMeli.Repository;

import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Model.Vendedor;

import java.util.List;

public interface ISocialMeliRepository {

    boolean follow(Integer compradorId, Integer vendedorId);

    boolean unFollow(Integer compradorId, Integer vendedorId);

    List<Comprador> vendedorFollowersList(List<Integer> followerIds);

    List<Vendedor> compradorFollowed(Integer compradorId);

    boolean newPost(Integer vendedorId, Publicacion publicacion);

    List<Publicacion> postByVendedorOfComprador(Integer compradorId);

    List<Comprador> vendedorFollowersOrderByName(Integer vendedorId, String orden);

    List<Vendedor> compradorFollowedOrderByName(Integer compradorId, String orden);

    List<Publicacion> postByVendedorOfCompradorOrderByDate(Integer compradorId, String orden);

    Comprador getComprador(Integer compradorId);

    Vendedor getVendedor(Integer vendedorId);

    Boolean existsFollow(Integer compradorId, Integer vendedorId);


}
