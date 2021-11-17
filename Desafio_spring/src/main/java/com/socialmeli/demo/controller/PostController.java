package com.socialmeli.demo.controller;

import com.socialmeli.demo.dto.PostDTO;
import com.socialmeli.demo.dto.UserWithFollowedPostsListDTO;
import com.socialmeli.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController implements IPostController{

    @Autowired
    private PostService postService;

    @Override
    public ResponseEntity<UserWithFollowedPostsListDTO> getUserWithFollowedPosts(Integer id, String order) {
        return new ResponseEntity<>(
                this.postService.getUserWithFollowedPosts(id, order),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<PostDTO> addPost(PostDTO postDTO) {
        return new ResponseEntity<>(
                this.postService.addPost(postDTO),
                HttpStatus.OK
        );
    }
}
