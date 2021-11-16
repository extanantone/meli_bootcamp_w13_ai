package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.request.PostInDTO;
import com.bootcamp.socialmeli.dto.request.PostInPromoDTO;
import com.bootcamp.socialmeli.dto.response.post.SellersPostsDTO;


public interface IProductService {

    void createPost(PostInDTO postIn);

    void createPostPromo(PostInPromoDTO postIn);

    SellersPostsDTO getSellersPosts (Integer purchaserId);

    SellersPostsDTO getSellersPostsSort (Integer purchaserId, String order);


}
