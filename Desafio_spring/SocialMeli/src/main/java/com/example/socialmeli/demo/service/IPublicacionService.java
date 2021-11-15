package com.example.socialmeli.demo.service;

import com.example.socialmeli.demo.dto.controllerToService.PublicacionDTO;
import com.example.socialmeli.demo.dto.controllerToService.PublicacionPromoDTO;
import com.example.socialmeli.demo.dto.controllerToService.RequestPostsFromFollowedsDTO;
import com.example.socialmeli.demo.dto.controllerToService.UserIdDTO;
import com.example.socialmeli.demo.dto.serviceToController.PostsFromMyFollowedUsersDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserPromoPostCountDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserPromoPostListDTO;
import org.springframework.http.ResponseEntity;

public interface IPublicacionService {

    public ResponseEntity createPost(PublicacionDTO p);

    public ResponseEntity createPromoPost(PublicacionPromoDTO publicacion);

    public ResponseEntity<PostsFromMyFollowedUsersDTO> getPostsFromUserFollowersSinceTwoWeeks(RequestPostsFromFollowedsDTO request);

    public ResponseEntity<UserPromoPostListDTO> getPromoPostListOfUserId(UserIdDTO request);

    public ResponseEntity<UserPromoPostCountDTO> countPromoPostOfUser(UserIdDTO userId);



}
