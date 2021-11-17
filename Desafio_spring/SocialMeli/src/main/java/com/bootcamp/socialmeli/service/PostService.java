package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.dto.ReqProductDTO;
import com.bootcamp.socialmeli.dto.UserPostDTO;
import com.bootcamp.socialmeli.model.Post;
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


    private List<Post> orderPostsByDate(List<Post> posts, String order) {
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

    private List<Post> sortPost (List<Post> posts, Comparator<Post> orderType) {
        return posts.stream().sorted(orderType).collect(Collectors.toList());
    }

}
