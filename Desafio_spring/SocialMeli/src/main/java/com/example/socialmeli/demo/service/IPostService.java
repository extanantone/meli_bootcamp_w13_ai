package com.example.socialmeli.demo.service;

import com.example.socialmeli.demo.dto.controllerToService.DTOPost;
import com.example.socialmeli.demo.dto.controllerToService.DTOPromoPost;
import com.example.socialmeli.demo.dto.controllerToService.DTORequestPostsFromFolloweds;
import com.example.socialmeli.demo.dto.controllerToService.DTOUserId;
import com.example.socialmeli.demo.dto.serviceToController.DTOPostsFromMyFollowedUsers;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserPromoPostCount;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserPromoPostList;
import org.springframework.http.ResponseEntity;

public interface IPostService {

    public ResponseEntity createPost(DTOPost p);

    public ResponseEntity createPromoPost(DTOPromoPost publicacion);

    public ResponseEntity<DTOPostsFromMyFollowedUsers> getPostsFromFollowedUsersSinceTwoWeeks(DTORequestPostsFromFolloweds request);

    public ResponseEntity<DTOUserPromoPostList> getPromoPostListOfUserId(DTOUserId request);

    public ResponseEntity<DTOUserPromoPostCount> countPromoPostOfUser(DTOUserId userId);


}
