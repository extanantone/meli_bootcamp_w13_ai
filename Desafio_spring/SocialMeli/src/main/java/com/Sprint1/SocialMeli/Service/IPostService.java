package com.Sprint1.SocialMeli.Service;

import com.Sprint1.SocialMeli.DTO.*;
import com.Sprint1.SocialMeli.Model.Post;
import com.Sprint1.SocialMeli.Model.User;

import java.util.HashMap;
import java.util.List;

public interface IPostService {
    //TODO: BORRAR
    public HashMap<Integer, Post> pruebaPost();

    public Boolean crearPublicacion(PostShortDTO publicacion);

    public PostListDTO obtenerListadoPostsDeVendedor (int userId, String order);

    public Boolean crearPostPromocion(PostFullDTO publicacionFull);

    public PromoPostCountDTO obtenerCantPromoPost (int vendedorId);

    //public PromoPostListDTO obtenerListPromoPost (int vendedorId);
}
