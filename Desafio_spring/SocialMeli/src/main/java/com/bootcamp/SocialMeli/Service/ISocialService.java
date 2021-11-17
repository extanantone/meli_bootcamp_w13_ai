package com.bootcamp.SocialMeli.Service;

import com.bootcamp.SocialMeli.DTO.*;
import com.bootcamp.SocialMeli.Model.Seguidor;

import java.util.List;

public interface ISocialService {
    //metodos servicio usuario
    SeguidorDTO postSeguidor(Seguidor seguidor);
    SeguidoresCountDTO getSequidores(Integer idUser);
    SeguidoresDTO getFollowers(Integer idUser);
    SeguidoresDTO getFollowed(Integer idUser);
    SeguidorDTO unFollow(Seguidor seguidor);
    SeguidoresDTO getOrderFollow(Integer id, String order);
    SeguidoresDTO getOrderFollowed(Integer id, String order);
    //metodos servicio publicacion
    PublicacionDTO setPublicacion(PublicacionDTO publicDTO);
    List getPublicacion(Integer userId);
    PublicUserDTO getPublicacionesRecientes(Integer userId,String order);
    PublicUserDTO getPubliOrderByFecha(Integer userId, String order);
    //metodos publicaciones con promo
    PromoPDTO setPromoPublicacion(PromoPDTO promopDTO);
    PromoPubliCountDTO getPromoPubliCount (Integer id);
    PromoPublicacionesDTO getPromoPublicaciones(Integer id);
}
