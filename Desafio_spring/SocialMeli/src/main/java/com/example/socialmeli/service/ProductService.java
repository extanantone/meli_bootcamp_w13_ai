package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostDto;
import com.example.socialmeli.dto.PostsDto;
import com.example.socialmeli.dto.UserDto;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IProductRepository;
import com.example.socialmeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    IProductRepository productRepository;
    IUserRepository userRepository;


    public ProductService(IProductRepository productRepository, IUserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createPost(Post post) {
        userRepository.findById(post.getUserId());
        if(!productRepository.findById(post.getIdPost())) {
            throw new BadRequestException("Ya existe un post con id:" + post.getIdPost());
        }

        productRepository.createPost(post);
    }

    @Override
    public PostsDto listPosts(Integer userId,String order){

        Map<Integer, UserDto> followed = userRepository.findById(userId).getFollowed();
        List<PostDto> posts = new ArrayList<>();

        for (UserDto user:followed.values()) {
            productRepository.listPosts(user.getUserId())
                    .stream()
                    .forEach(x -> posts.add(new PostDto(x)));
        }

        if(order.equals("date_asc")) {
            return new PostsDto(userId,
                    posts.stream()
                            .sorted(Comparator.comparing(PostDto::getDate))
                            .collect(Collectors.toList())
            );
        } else {

            return new PostsDto(userId,
                    posts.stream()
                            .sorted(Comparator.comparing(PostDto::getDate).reversed())
                            .collect(Collectors.toList()));
        }

    }

    @Override
    public PostsDto promoPostCount(Integer userId){

        userRepository.findById(userId);

        return new PostsDto(userId,productRepository.promoPost(userId).size());
    }

    @Override
    public PostsDto promoList(Integer userId) {
        User user = userRepository.findById(userId);
        List<PostDto> posts = productRepository.promoPost(userId).stream().map(PostDto::new).collect(Collectors.toList());
        return new PostsDto(user,posts);

    }
}
