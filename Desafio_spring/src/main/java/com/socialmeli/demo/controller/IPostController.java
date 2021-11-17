package com.socialmeli.demo.controller;

import com.socialmeli.demo.dto.PostDTO;
import com.socialmeli.demo.dto.UserWithFollowedPostsListDTO;
import com.socialmeli.demo.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("products")
public interface IPostController {

    @GetMapping("followed/{user_id}/list")
    public  ResponseEntity<UserWithFollowedPostsListDTO> getUserWithFollowedPosts(@PathVariable("user_id") Integer id,
                                                                                  @RequestParam(value = "order", required = false) String order);

    @PostMapping("post")
    public ResponseEntity<PostDTO> addPost(@RequestBody PostDTO postDTO);

}
