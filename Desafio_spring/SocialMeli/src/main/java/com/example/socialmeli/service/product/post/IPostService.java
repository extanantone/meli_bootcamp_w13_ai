package com.example.socialmeli.service.product.post;

import com.example.socialmeli.dto.post.*;

public interface IPostService
{
    UserPostDTO create(UserPostDTO postDTO);

    UserPromoPostDTO createPromo(UserPromoPostDTO userPromoPostDTO);

    PostFollowedDTO listRecentFollowedProducts(int userId, String order);

    PromoPostCountDTO promoPostCount(int userId);

    PromoPostListDTO promoPostList(int userId);
}
