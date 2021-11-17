package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.CountDTO;
import com.bootcamp.SocialMeli.dto.FollowedDTO;
import com.bootcamp.SocialMeli.dto.FollowerDTO;
import com.bootcamp.SocialMeli.dto.MessageDTO;
import com.bootcamp.SocialMeli.dto.PublicationDTO;
import com.bootcamp.SocialMeli.dto.UserPublicationDTO;
import com.bootcamp.SocialMeli.model.Publication;
import com.bootcamp.SocialMeli.service.ISocialMeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialMeliController {
    @Autowired
    ISocialMeliService isocialMeliService;

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    ResponseEntity<MessageDTO> follow(@PathVariable Integer user_id, @PathVariable Integer user_id_to_follow) {
        this.isocialMeliService.newFollow(user_id, user_id_to_follow);
        MessageDTO msj = new MessageDTO("Ahora le estás siguiendo");
        return new ResponseEntity<>(msj, HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/count")
    ResponseEntity<CountDTO> followersCount(@PathVariable Integer user_id){
        return new ResponseEntity<>(isocialMeliService.followerCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    ResponseEntity<FollowerDTO> followerList(@PathVariable Integer user_id, @RequestParam(value = "order", required = false) String order)  {
        return new ResponseEntity(this.isocialMeliService.followerList(user_id, order), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    ResponseEntity<FollowedDTO> followedList(@PathVariable Integer user_id, @RequestParam(value = "order", required = false) String order) {
        return new ResponseEntity<>(this.isocialMeliService.followedList(user_id, order), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<Publication> createPublication(@RequestBody PublicationDTO publicationDTO) {
        Publication response = isocialMeliService.newPublication(publicationDTO);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }


    @GetMapping("/products/followed/{user_id}/list")
    ResponseEntity<Publication> recentPublication(@PathVariable Integer user_id,@RequestParam(name= "order", required = false) String order){
        UserPublicationDTO response = isocialMeliService.recentPublication(user_id, order);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    ResponseEntity<MessageDTO> unfollow(@PathVariable Integer user_id, @PathVariable Integer user_id_to_unfollow) {
        this.isocialMeliService.deleteFollow(user_id, user_id_to_unfollow);
        MessageDTO msg = new MessageDTO("Ya le dejaste de seguir");
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}