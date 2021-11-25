package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.CreatePostDTO;
import com.bootcamp.socialmeli.dto.Ordenable;
import com.bootcamp.socialmeli.dto.PromoCountDTO;

public interface IPostService {
    Long createPost(CreatePostDTO post);
    Ordenable listFollowedPosts(Long userID, String order);
    PromoCountDTO promoCountByUser(Long userID);
    Ordenable listPromoPostsByUser(Long userID, String order);
}
