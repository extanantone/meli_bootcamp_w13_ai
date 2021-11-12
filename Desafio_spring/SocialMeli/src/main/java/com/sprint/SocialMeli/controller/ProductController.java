package com.sprint.SocialMeli.controller;

import com.sprint.SocialMeli.dto.PostDto;
import com.sprint.SocialMeli.exceptions.NotFoundException;
import com.sprint.SocialMeli.exceptions.WrongTypeException;
import com.sprint.SocialMeli.service.ISocialService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    ISocialService socialService;
    public ProductController(ISocialService socialService){
        this.socialService = socialService;
    }

    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public HttpStatus newProduct(@RequestBody PostDto) throws WrongTypeException, NotFoundException {
        socialService.
        return HttpStatus.OK;
    }

}
