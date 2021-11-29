package com.bootcamp.SocialMeli.Repository;

import com.bootcamp.SocialMeli.Model.PromoPublicacion;
import com.bootcamp.SocialMeli.Model.Publicacion;
import com.bootcamp.SocialMeli.Model.Seguidor;
import com.bootcamp.SocialMeli.Model.Usuario;
import java.util.List;

public interface ISocialRepository {
    //Seguir un usuario o vendedor
    Seguidor Follow(Seguidor seguidor);
    // Dejar de seguir un usuario o vendedor
    void unFollow(Seguidor seguidor);
    //Retornar si un usuario ya es seguido
    Boolean getExisteSeguidorById(Integer userId, Integer userFolloId);
    //Traer un usuario por ID
    Usuario getUsuario(Integer userId);
    //Crea un usuario
    void setUsuario(Usuario usuario);
    //Traer lista de seguidores
    List<Seguidor> getSeguidor();
    //Crear una publicacion
    Publicacion setPublicacion(Publicacion publica);
    //Trae lista de publicaciones
    List<Publicacion> getPublicaciones(Integer id);
    Publicacion getPublicacion(Integer id);
    //Crea una publicacion con promo
    void setPromoPublic(PromoPublicacion promo);
    //trae una publicacion
    PromoPublicacion getPromoPublicacion(Integer id);
    //Lista las publicaciones
    List<PromoPublicacion> getPromoPubliList(Integer id);
    //Retornar si un post ya existe
    Boolean getExisteSPostById(Integer userId, Integer postId);

}
