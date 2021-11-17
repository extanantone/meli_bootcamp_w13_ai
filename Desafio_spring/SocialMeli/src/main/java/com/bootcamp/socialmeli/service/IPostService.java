package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.model.Post;

import java.util.Comparator;
import java.util.List;

public interface IPostService {
    public void createNewPost(ReqProductDTO reqProductDTO);
    public UserPostDTO getRecientPost(Long idUser, String prefix);

    public UserPromoListDTO getPromosCount (Long idUser);
    public List<Post> orderPostsByDate(List<Post> posts, String order);
    public List<Post> sortPost(List<Post> posts, Comparator<Post> orderType);
    public void createPromo(ReqPromotionDTO reqPromotionDTO);
    public UserPromoAllDTO getAllPromotionsList(Long idUser);
}
