package com.sprint.SocialMeli.controller;

import com.sprint.SocialMeli.dto.FollowedPostListDto;
import com.sprint.SocialMeli.dto.PostDtoIn;
import com.sprint.SocialMeli.exceptions.NotFoundException;
import com.sprint.SocialMeli.exceptions.WrongTypeException;
import com.sprint.SocialMeli.service.ISocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    ISocialService socialService;
    public ProductController(ISocialService socialService){
        this.socialService = socialService;
    }

    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public HttpStatus newProduct(@RequestBody PostDtoIn postDtoIn){
        socialService.newPost(postDtoIn);
        return HttpStatus.OK;
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<FollowedPostListDto> postList(@PathVariable int user_id) throws WrongTypeException, NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getLastTwoWeeksPostsFromABuyerFollowed(user_id));
    }

}
