package com.Sprint1.SocialMeli.Service;

import com.Sprint1.SocialMeli.DTO.PostListDTO;
import com.Sprint1.SocialMeli.DTO.PostShortDTO;
import com.Sprint1.SocialMeli.Model.Post;
import com.Sprint1.SocialMeli.Model.User;

import java.util.HashMap;
import java.util.List;

public interface IPostService {
    //TODO: BORRAR
    public HashMap<Integer, Post> pruebaPost();

    public Boolean crearPublicacion(PostShortDTO publicacion);

    public PostListDTO obtenerListadoPostsDeVendedor (int userId);
}
