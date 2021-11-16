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
        List<Post> recentPostsByFollowed = vendedorRepository.getRecentPosts(idUser);
        if (!Objects.isNull(order)) {
            recentPostsByFollowed = this.orderPostsByDate(recentPostsByFollowed, order);
        }
        return new UserPostDTO(idUser, recentPostsByFollowed.stream().map(
                p -> mapper.map(p, PostDTO.class)).collect(Collectors.toList()));
    }


    private List<Post> orderPostsByDate(List<Post> inPosts, String order) {
        List<Post> post = inPosts;
        if (order.equals("date_asc")) {
            post = post.stream().sorted(
                            Comparator.comparing(Post::getPublishDate)).
                    collect(Collectors.toList());
        } else if (order.equals("date_desc")) {
            post = post.stream().sorted(
                            Comparator.comparing(Post::getPublishDate, Collections.reverseOrder())).
                    collect(Collectors.toList());
            //TODO: Throw except
        } else return null;
        return post;
    }

}
