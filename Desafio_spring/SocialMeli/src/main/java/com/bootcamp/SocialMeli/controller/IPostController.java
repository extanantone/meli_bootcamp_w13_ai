package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.PostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPostController {
    @PostMapping("products/post")
    ResponseEntity<Void> create(@RequestBody PostDTO post);
}
