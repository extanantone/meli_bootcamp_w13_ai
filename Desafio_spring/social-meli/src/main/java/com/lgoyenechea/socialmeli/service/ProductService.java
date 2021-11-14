package com.lgoyenechea.socialmeli.service;

import com.lgoyenechea.socialmeli.dto.PostCreationDTO;
import com.lgoyenechea.socialmeli.dto.PostDTO;
import com.lgoyenechea.socialmeli.dto.mapper.ProductMapper;
import com.lgoyenechea.socialmeli.model.Post;
import com.lgoyenechea.socialmeli.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public PostDTO save(PostCreationDTO newPost) {
        Post post = productRepository.save(ProductMapper.postCreationDtoToPost(newPost));
        return ProductMapper.postToDto(post);
    }
}
