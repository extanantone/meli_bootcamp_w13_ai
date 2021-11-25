package com.sprint.SocialMeli.controller;

import com.sprint.SocialMeli.dto.in.PostDtoIn;
import com.sprint.SocialMeli.dto.in.PromoPostDtoIn;
import com.sprint.SocialMeli.dto.out.FollowedPostListDto;
import com.sprint.SocialMeli.dto.out.PromoPostCountDto;
import com.sprint.SocialMeli.dto.out.PromoPostList;
import com.sprint.SocialMeli.service.ISocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    ISocialService socialService;
    public ProductController(ISocialService socialService){
        this.socialService = socialService;
    }

    // US0005
    @PostMapping("/post")
    public HttpStatus newProduct(@RequestBody @Valid PostDtoIn postDtoIn) throws Exception {
        socialService.newPost(postDtoIn);
        return HttpStatus.OK;
    }

    // US0006 + US0009
    // Para fusionar las US se aplico el RequestParam como no requerido, de forma que se puede llamar con o sin el order.
    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<FollowedPostListDto> postListSorted(@PathVariable int user_id, @RequestParam(value = "order", required=false) String order) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getLastTwoWeeksPostsFromFollowed(user_id, order));
    }

    // US0010
    @PostMapping("/promo-post")
    public HttpStatus newPromoProduct(@RequestBody @Valid PromoPostDtoIn promoPostDtoIn) throws Exception {
        socialService.newPromoPost(promoPostDtoIn);
        return HttpStatus.OK;
    }

    // US0011
    @GetMapping("/{user_id}/promo-post/count")
    public ResponseEntity<PromoPostCountDto> getPromoPostCount(@PathVariable int user_id) throws Exception {
        return ResponseEntity.ok(socialService.getPromoPostCount(user_id));
    }

    // US0012
    @GetMapping("/{user_id}/list")
    public ResponseEntity<PromoPostList> getPromoPostList(@PathVariable int user_id) throws Exception{
        return ResponseEntity.ok(socialService.getPromoPostList(user_id));
    }




}
