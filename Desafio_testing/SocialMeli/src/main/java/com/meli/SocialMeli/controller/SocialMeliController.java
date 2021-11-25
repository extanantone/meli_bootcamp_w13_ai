package com.meli.SocialMeli.controller;

import com.meli.SocialMeli.dto.*;
import com.meli.SocialMeli.service.ISocialMeliService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialMeliController implements ISocialMeliController {
    ISocialMeliService socialMeliService;

    public SocialMeliController(ISocialMeliService socialMeliService) {
        this.socialMeliService = socialMeliService;
    }

    @Override
    public ResponseEntity<MensajeDTO> addFollow(int userId, int userIdFollow) {
        MensajeDTO response = socialMeliService.addFollow(userId, userIdFollow);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CountDTO> countFollowers(int userId) {
        return new ResponseEntity<>(socialMeliService.countFollowers(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FollowersDTO> listFollowers(int userId, String order) {
        return new ResponseEntity<>(socialMeliService.listFollowers(userId, order), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FollowedDTO> listFollowed(int userId, String order) {
        return  new ResponseEntity<>(socialMeliService.listFollowed(userId, order), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MensajeDTO> addPost(PostDTOResponse post) {
        return new ResponseEntity<>(socialMeliService.addPost(post), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ListPostsDTO> listPostFollowed(int userId, String order) {
        return new ResponseEntity<>(socialMeliService.listPostFollowed(userId, order), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MensajeDTO> unfollow(int userId, int userIdFollow) {
        return new ResponseEntity<>(socialMeliService.unfollow(userId, userIdFollow), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MensajeDTO> addPromo(PromoDTO promo) {
        return new ResponseEntity<>(socialMeliService.addPromo(promo), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ListPromoDTO> listPromo(int userId, String order) {
        return new ResponseEntity<>(socialMeliService.listPromo(userId, order), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CountDTO> countPromo(int userId) {
        return new ResponseEntity<>(socialMeliService.countPromos(userId), HttpStatus.OK);
    }
}
