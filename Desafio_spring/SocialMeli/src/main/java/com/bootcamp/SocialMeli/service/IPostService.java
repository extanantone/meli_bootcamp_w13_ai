package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.dto.PublicacionesDTO;

public interface IPostService {

    public PostDTO setPost(PostDTO postDTO);
    PublicacionesDTO getPublicaciones(int id);
    PublicacionesDTO getPublicaciones(int id , String order);
}
