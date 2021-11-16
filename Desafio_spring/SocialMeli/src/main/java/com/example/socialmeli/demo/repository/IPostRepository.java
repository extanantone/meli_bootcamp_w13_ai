package com.example.socialmeli.demo.repository;


import com.example.socialmeli.demo.model.Post;

import java.util.List;

public interface IPostRepository {

    public Post crearPublicacion(Post p);

   public List<Post>  obtenerPublicacionesPorVendedorIdPosteriores2Semanas(int userId, String order);

    public List<Post> getPromoPostListOfUserId(int userId);

   public int countPromoPostOfUser(int userId);

}
