package com.example.SocialMeli.services;

import com.example.SocialMeli.dto.PostDTO;
import com.example.SocialMeli.repository.ProductRepository;
import com.example.SocialMeli.repository.UserRepository;
import com.example.SocialMeli.services.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Boolean saveProduct(PostDTO postDTO) throws Exception {
        this.userRepository.savePost(postDTO.getId(), postDTO.getUserId());
        return this.productRepository.saveProduct(ProductMapper.toEntity(postDTO));
    }
}
