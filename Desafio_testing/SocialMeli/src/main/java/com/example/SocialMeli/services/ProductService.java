package com.example.SocialMeli.services;

import com.example.SocialMeli.dto.PostDTO;
import com.example.SocialMeli.dto.VendedorDTO;

import java.util.List;

public interface ProductService {

    Boolean saveProduct(PostDTO postDTO) throws Exception;

    List<VendedorDTO> getSellerFollowed(int userId, String order) throws Exception;
}
