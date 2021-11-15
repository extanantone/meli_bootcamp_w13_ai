package com.example.socialmeli.demo.service;

import com.example.socialmeli.demo.dto.controllerToService.PublicacionDTO;
import com.example.socialmeli.demo.dto.controllerToService.RequestPostsFromFollowedsDTO;
import com.example.socialmeli.demo.dto.serviceToController.PostsFromMyFollowedUsersDTO;
import org.springframework.http.ResponseEntity;

public interface IPublicacionService {

    public ResponseEntity createPost(PublicacionDTO p);

    public ResponseEntity<PostsFromMyFollowedUsersDTO> getPostsFromUserFollowersSinceTwoWeeks(RequestPostsFromFollowedsDTO request);



}
