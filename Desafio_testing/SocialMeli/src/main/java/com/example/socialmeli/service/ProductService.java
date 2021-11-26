package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostDto;
import com.example.socialmeli.dto.PostsDto;
import com.example.socialmeli.dto.UserDto;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.dto.PostCreateDto;
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
    public void createPost(PostCreateDto postCreateDto) {
        userRepository.findById(postCreateDto.getUserId());
        if(!productRepository.findById(postCreateDto.getIdPost())) {
            throw new BadRequestException("Ya existe un post con id:" + postCreateDto.getIdPost());
        }

        productRepository.createPost(postCreateDto);
    }

    @Override
    public PostsDto listPosts(Integer userId,String order){

        if (order.equals("date_asc") || order.equals("date_desc")) {
            Map<Integer, UserDto> followed = userRepository
                    .findById(userId).orElseThrow(() -> new BadRequestException("Usuario no encontrado con id:" + userId))
                    .getFollowed();

            List<PostDto> posts = new ArrayList<>();

            for (UserDto user : followed.values()) {
                productRepository.listPosts(user.getUserId())
                        .stream()
                        .forEach(x -> posts.add(new PostDto(x)));
            }

            if (order.equals("date_asc")) {
                return new PostsDto(userId,
                        posts.stream()
                                .sorted(Comparator.comparing(PostDto::getDate))
                                .collect(Collectors.toList())
                );
            }

            return new PostsDto(userId,
                    posts.stream()
                            .sorted(Comparator.comparing(PostDto::getDate).reversed())
                            .collect(Collectors.toList()));

        } else {
            throw new BadRequestException("Ordenamiento no valido");
        }

    }

    @Override
    public PostsDto promoPostCount(Integer userId){

        userRepository.findById(userId);

        return new PostsDto(userId,productRepository.promoPost(userId).size());
    }

    @Override
    public PostsDto promoList(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("Usuario no encontrado con id:" + userId));;
        List<PostDto> posts = productRepository.promoPost(userId).stream().map(PostDto::new).collect(Collectors.toList());
        return new PostsDto(user,posts);

    }
}
