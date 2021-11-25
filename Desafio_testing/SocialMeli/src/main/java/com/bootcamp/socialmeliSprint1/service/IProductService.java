package com.bootcamp.socialmeliSprint1.service;

import com.bootcamp.socialmeliSprint1.dto.request.PostInDTO;
import com.bootcamp.socialmeliSprint1.dto.request.PostInPromoDTO;
import com.bootcamp.socialmeliSprint1.dto.response.post.ProductsPromoInfoDTO;
import com.bootcamp.socialmeliSprint1.dto.response.post.SellerProductsInPromoListDTO;
import com.bootcamp.socialmeliSprint1.dto.response.post.SellersPostsDTO;


public interface IProductService {

    void createPost(PostInDTO postIn);

    void createPostPromo(PostInPromoDTO postIn);

    SellersPostsDTO getSellersPosts (Integer purchaserId);

    SellersPostsDTO getSellersPostsSort (Integer purchaserId, String order);

    SellerProductsInPromoListDTO getProductsInPromo(Integer sellerId);

    ProductsPromoInfoDTO getNumberOfProductsInPromo(Integer sellerId);
}
