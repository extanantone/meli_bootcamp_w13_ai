package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Promotion;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.VendedorRepository;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    VendedorRepository vendedorRepository;


    ModelMapper mapper = new ModelMapper();


    //US0005
    @Override
    public void createNewPost(ReqProductDTO reqProductDTO) {
        vendedorRepository.addPostToUser(reqProductDTO.getUserId(), mapper.map(reqProductDTO, Post.class));
    }

    //US0006
    @Override
    public UserPostDTO getRecientPost(Long idUser, String order) {
        List<Post> recentPostsByFollowed = vendedorRepository.getFolloweds(idUser).stream().map(
                        u -> vendedorRepository.getRecentPosts(u.getUserId())).
                flatMap(Collection::stream).sorted(Comparator.comparing(Post::getDate,
                        Collections.reverseOrder())).collect(Collectors.toList());
        if (!Objects.isNull(order)) {
            recentPostsByFollowed = orderPostsByDate(recentPostsByFollowed, order);
        }
        return new UserPostDTO(idUser, recentPostsByFollowed.stream().map(
                p -> mapper.map(p, PostDTO.class)).collect(Collectors.toList()));
    }


    @Override
    public List<Post> orderPostsByDate(List<Post> posts, String order) {
        Comparator<Post> orderType;
        if (order.equals("date_asc")) {
            orderType = Comparator.comparing(Post::getDate);
        } else if (order.equals("date_desc")) {
            orderType = Comparator.comparing(Post::getDate,
                    Collections.reverseOrder());
            // TODO: make except
        } else return null;
        return this.sortPost(posts, orderType);
    }

    @Override
    public List<Post> sortPost(List<Post> posts, Comparator<Post> orderType) {
        return posts.stream().sorted(orderType).collect(Collectors.toList());
    }


    // US0010
    @Override
    public void createPromo(ReqPromotionDTO reqPromotionDTO) {

        //TODO: Make exceptions
        vendedorRepository.addPostToUser(reqPromotionDTO.getUserId(),
                mapper.map(reqPromotionDTO, Promotion.class));
    }


    @Override
    public UserPromoListDTO getPromosCount(Long idUser) {
        User user = vendedorRepository.getUser(idUser);
        Integer promosCount = vendedorRepository.getPromoPosts(idUser).size();
        return new UserPromoListDTO(idUser, user.getUserName(), promosCount);
    }

    @Override
    public UserPromoAllDTO getAllPromotionsList(Long idUser) {
        User user = vendedorRepository.getUser(idUser);
        List<Post> promotions = vendedorRepository.getPromoPosts(idUser);
        return new UserPromoAllDTO(user.getUserId(), user.getUserName(), promotions.stream().
                map(p -> mapper.map(p, PromotionDTO.class)).collect(Collectors.toList()));
    }
}
