package com.Sprint1.SocialMeli.Repository;

import com.Sprint1.SocialMeli.DTO.PostFullDTO;
import com.Sprint1.SocialMeli.DTO.PromoPostListDTO;
import com.Sprint1.SocialMeli.Model.Post;
import com.Sprint1.SocialMeli.Model.Product;
import com.Sprint1.SocialMeli.Model.User;

import java.util.HashMap;
import java.util.List;

public interface IPostRepository {
    public Boolean crearPublicacion(Post publicacion);

    public List<Post> obtenerPostsPorVendedor (int vendedorId);

    public Boolean existePost(int postId);

    public Boolean crearPublicacionPromocion(Post publicacionFull);

    public int obtenerCantPromoPost (int vendedorId);

    public List<PostFullDTO> obtenerListPromoPost (int vendedorId);
}
