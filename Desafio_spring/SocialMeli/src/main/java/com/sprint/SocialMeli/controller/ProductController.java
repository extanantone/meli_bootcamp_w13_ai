package com.sprint.SocialMeli.controller;

import com.sprint.SocialMeli.dto.in.PostDtoIn;
import com.sprint.SocialMeli.dto.in.PromoPostDtoIn;
import com.sprint.SocialMeli.dto.out.FollowedPostListDto;
import com.sprint.SocialMeli.dto.out.PromoPostCountDto;
import com.sprint.SocialMeli.dto.out.PromoPostList;
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

    // US0005
    @PostMapping("/post")
    public HttpStatus newProduct(@RequestBody PostDtoIn postDtoIn) throws WrongTypeException, NotFoundException {
        socialService.newPost(postDtoIn);
        return HttpStatus.OK;
    }

    // US0006
    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<FollowedPostListDto> postList(@PathVariable int user_id) throws WrongTypeException, NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getLastTwoWeeksPostsFromFollowed(user_id, null));
    }

    // US0006
    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<FollowedPostListDto> postListSorted(@PathVariable int user_id, @RequestParam String order) throws WrongTypeException, NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getLastTwoWeeksPostsFromFollowed(user_id, order));
    }

    // US0010
    @PostMapping("/promo-post")
    public HttpStatus newPromoProduct(@RequestBody PromoPostDtoIn promoPostDtoIn) throws WrongTypeException, NotFoundException {
        socialService.newPromoPost(promoPostDtoIn);
        return HttpStatus.OK;
    }

    // US0011
    @GetMapping("/promo/{user_id}/promo-post/count")
    public ResponseEntity<PromoPostCountDto> getPromoPostCount(@PathVariable int user_id) throws WrongTypeException, NotFoundException {
        return ResponseEntity.ok(socialService.getPromoPostCount(user_id));
    }

    // US0012
    @GetMapping("/{user_id}/list")
    public ResponseEntity<PromoPostList> getPromoPostList(@PathVariable int user_id) throws WrongTypeException, NotFoundException {
        return ResponseEntity.ok(socialService.getPromoPostList(user_id));
    }




}
