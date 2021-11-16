package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.mapper.IMapper;
import com.bootcamp.socialmeli.repository.IPostRepository;
import com.bootcamp.socialmeli.repository.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {

    private final IPostRepository postRepository;
    private final IProductRepository productRepository;
    private final IMapper mapper;

    public PostService(IPostRepository postRepository, IProductRepository productRepository, IMapper mapper) {
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public PostDTO getPost(long id) {
        return mapper.postToPostDTO(
                postRepository.getPost(id),
                productRepository.getProduct(postRepository.getPost(id).getProductId())
        );
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        return mapper.postToPostDTO(
                postRepository.createPost(mapper.postDTOToPost(postDTO)),
                productRepository.createProduct(mapper.productDTOToProduct(postDTO.getProduct()))
        );
    }
}
