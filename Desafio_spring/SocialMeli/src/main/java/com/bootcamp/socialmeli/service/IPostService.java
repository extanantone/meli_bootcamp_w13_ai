package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.ReqProductDTO;
import com.bootcamp.socialmeli.dto.UserPostDTO;
import com.bootcamp.socialmeli.dto.UserPromoAllDTO;
import com.bootcamp.socialmeli.dto.UserPromoListDTO;

public interface IPostService {
    public void createNewPost(ReqProductDTO reqProductDTO);
    public UserPostDTO getRecientPost(Long idUser, String prefix);

    public UserPromoListDTO getPromosCount (Long idUser);

    public UserPromoAllDTO getAllPromotionsList(Long idUser);
}
