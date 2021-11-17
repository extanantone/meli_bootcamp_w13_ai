package com.example.socialmeli.service.post;

import com.example.socialmeli.dto.*;

public interface IPostService
{
    UserPostDTO create(UserPostDTO postDTO);

    UserPromoPostDTO createPromo(UserPromoPostDTO userPromoPostDTO);

    ProductFollowedDTO listRecentFollowedProducts(int userId, String order);

    PromoPostCountDTO promoPostCount(int userId);

    PromoPostListDTO promoPostList(int userId);
}
