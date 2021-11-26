package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.model.PromoPost;

public interface IPostService {

    public PostDTO setPost(PostDTO postDTO);
    PublicacionesDTO getPublicaciones(int id);
    PublicacionesDTO getPublicaciones(int id , String order);

    PromopostDTO setPromopost(PromopostDTO promopostDTO);
    PromoPostCoutDTO getCountPromo (int id);
    PublicacionesPromoDTO getpublicacionesPromo(int id);
}
