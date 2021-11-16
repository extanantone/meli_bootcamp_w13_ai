package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.FollowedPostsDTO;
import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.mapper.IPostMapper;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController implements IPostController {
    @Autowired IPostMapper postMapper;
    @Autowired IPostService postService;


    @PostMapping("products/post")
    public ResponseEntity<Void> create(@RequestBody PostDTO postDTO) {
        //agregar validación de input
        Post post = postMapper.postDTOToPost(postDTO);
        postService.addPost(post);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FollowedPostsDTO> getFollowedPosts(int user_id) {
        FollowedPostsDTO followedPosts = postService.getFollowedPosts(user_id);
        return new ResponseEntity<>(followedPosts, HttpStatus.OK);
    }
}
