package com.SocialMeli.Sprint1SocialMeli.Repository;

import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Model.Vendedor;

import java.util.List;

public interface ISocialMeliRepository {

    boolean follow(Integer compradorId, Integer vendedorId);

    boolean unFollow(Integer compradorId, Integer vendedorId);

    boolean newPost(Integer vendedorId, Publicacion publicacion);

    Comprador getComprador(Integer compradorId);

    Vendedor getVendedor(Integer vendedorId);

    Boolean existsFollow(Integer compradorId, Integer vendedorId);

    Boolean existPost(Integer vendedorId, Integer postId);

    List<Publicacion> getProductoPromoCountByVendedorId(Integer vendedorId);


}
