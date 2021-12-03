package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.repository.ProductRepository;
import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.model.*;
import com.bootcamp.SocialMeli.exception.*;

import com.bootcamp.SocialMeli.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository repositoryProducts;
    private UserRepository repositoryUsers;
    private UserService userService;

    public ProductServiceImpl(ProductRepository repositoryProducts, UserRepository repositoryUsers, UserService userService) {
        this.repositoryProducts = repositoryProducts;
        this.repositoryUsers = repositoryUsers;
        this.userService = userService;
    }

    @Override
    public void post(PostDTO newPost) {
        if (repositoryUsers.userExists(newPost.getUserId())) {
            if (!repositoryProducts.getAllPosts().contains(newPost.getDetail().getProduct_id())){
                //formatting date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
                String date = newPost.getDate();
                LocalDate localDate = LocalDate.parse(date, formatter);

                Product newProduct = new Product(newPost.getDetail().getProduct_id(),
                        newPost.getDetail().getProductName(), newPost.getDetail().getType(),
                        newPost.getDetail().getBrand(), newPost.getDetail().getColor(), newPost.getDetail().getNotes());

                Post postToAdd = new Post(newPost.getUserId(), newPost.getId_post(),
                        localDate, newProduct, newPost.getCategory(), newPost.getPrice());

                repositoryProducts.post(postToAdd);
            }else {
                throw new PostIdAlreadyExistsException(newPost.getDetail().getProduct_id());
            }
        }else {
            throw new UserIdNotFoundException(newPost.getUserId());
        }


    }

    @Override
    public List<Post> getPostList() {
        return repositoryProducts.getAllPosts();
    }

    public List<Post> getPostListById(int userId) {
        return repositoryProducts.getPostsById(userId);
    }

    // US 0009 - productService Implemantacion

    @Override
    public PostDoneDTO getPostListFrom2WeeksAgo(int userId, String order) {
        if (repositoryUsers.userExists(userId)) {
            List<Integer> followedIDs = new ArrayList<>();
            List<User> followed = userService.getFollowedList(userId).getFollowed();
            for (User follower : followed) {
                followedIDs.add(follower.getUserId());
            }
            //converting to PostResponseDTO
            LocalDate startDate = LocalDate.now().minusDays(15);
            PostDoneDTO postResponseDTO = new PostDoneDTO(userId, new ArrayList<>());
            if (order.equalsIgnoreCase("date_asc")) {
                for (int i = 0; i < followedIDs.size(); i++) {
                    for (Post post : repositoryProducts.getPostListFrom2WeeksAgoAsc(followedIDs.get(i))) {
                        postResponseDTO.getPosts().add(new PostResponseDTO(post.getPostId(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice()));
                    }
                    postResponseDTO.getPosts().stream().filter(post -> post.getDate().isAfter(startDate)).collect(Collectors.toList());
                    Collections.sort(postResponseDTO.getPosts(), Comparator.comparing(PostResponseDTO::getDate));
                }
            } else if (order.equalsIgnoreCase("date_desc")) {
                for (int i = 0; i < followedIDs.size(); i++) {
                    for (Post post : repositoryProducts.getPostListFrom2WeeksAgoDesc(followedIDs.get(i))) {
                        postResponseDTO.getPosts().add(new PostResponseDTO(post.getPostId(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice()));
                    }
                }
            } else {
                throw new NotValidParamException(order);
            }

            return postResponseDTO;

        } else {
            throw new UserIdNotFoundException(userId);
        }

    }
}
