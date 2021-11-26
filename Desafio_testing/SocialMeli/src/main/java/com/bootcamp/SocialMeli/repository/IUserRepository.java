package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.PromoPost;
import com.bootcamp.SocialMeli.model.Seguidor;
import com.bootcamp.SocialMeli.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    Seguidor setSeguidor(Seguidor seguidor);

    User getUser(int id);

    List<Seguidor> getSegidor();

    void setPost(Post post);

    Post getPost(int id);

    void cambiarTipo(int id);

    Post getPotsidUser(int id);
    List<Post> getPosts(int id);

    void dejarDeSeguir(int idSeguidor, int idSeguido);

    boolean getExisteSeguidor(int idseguidor , int idseguido);

    void setpromopost(PromoPost post);

    PromoPost getPromoPost(int id);

    List<PromoPost> getlistPromopost(int id);

    void setUser(User user);

}
