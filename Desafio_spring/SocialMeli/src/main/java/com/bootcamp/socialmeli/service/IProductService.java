package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.RequestPostDTO;
import com.bootcamp.socialmeli.dto.ResponsePostDTO;


public interface IProductService {
    void postProduct(RequestPostDTO requestPostDTO);
    ResponsePostDTO getProductsFollowed(int userId, String order);
}
