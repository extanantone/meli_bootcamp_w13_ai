package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.dto.PublicacionesDTO;
import com.bootcamp.SocialMeli.service.IPostService;
import com.bootcamp.SocialMeli.service.IUserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = "/products")
public class PostController {
    @Autowired
    IPostService iPostService;

    @PostMapping("/post")
    public ResponseEntity<PostDTO> setpost(@RequestBody PostDTO postDTO ){
        return new ResponseEntity<>(iPostService.setPost(postDTO), HttpStatus.OK);
    }

    @GetMapping("followed/{user_id}/list")
    public ResponseEntity<PublicacionesDTO> getPublicaciones(@PathVariable int user_id){
        return new ResponseEntity<>(iPostService.getPublicaciones(user_id),HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<PublicacionesDTO> getListPostOrder(@PathVariable int user_id, @PathParam("order") String order){
        return new ResponseEntity<>(iPostService.getPublicaciones(user_id, order),HttpStatus.OK);
    }


}
