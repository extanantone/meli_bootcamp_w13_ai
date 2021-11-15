package com.example.SocialMeli.services;

import com.example.SocialMeli.dto.PostDTO;

public interface ProductService {

    Boolean saveProduct(PostDTO postDTO) throws Exception;
}
