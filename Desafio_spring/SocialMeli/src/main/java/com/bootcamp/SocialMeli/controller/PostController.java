package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController implements IPostController {
    @Autowired
    IPostService postService;

    @Override
    public ResponseEntity<Void> create(@RequestBody PostDTO post) {
        //agregar validación de input
        //create product
        //find user
        //tirar excepción si el usuario no existe
        //tirar excepción si el usuario no puede vender
        //user.addProduct(product)
        return null;
    }
}
