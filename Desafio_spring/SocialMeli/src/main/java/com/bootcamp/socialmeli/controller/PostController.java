package com.bootcamp.socialmeli.controller;


import com.bootcamp.socialmeli.dto.MessageDTO;
import com.bootcamp.socialmeli.dto.ReqProductDTO;
import com.bootcamp.socialmeli.dto.UserPostDTO;
import com.bootcamp.socialmeli.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<MessageDTO> addNewPost(@RequestBody ReqProductDTO newPostReq) {
        this.postService.createNewPost(newPostReq);
        MessageDTO msg = new MessageDTO("Ok");
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<UserPostDTO> getRecentPostsByFollowed (
            @PathVariable("user_id") Long idUser,
            @RequestParam(value = "order", required = false) String order) {
        return new ResponseEntity(postService.getRecientPost(idUser, order),
                HttpStatus.OK);
    }


}
