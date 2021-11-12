package ruiz_facundo.SocialMeli.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruiz_facundo.SocialMeli.dto.*;
import ruiz_facundo.SocialMeli.service.SocialMeliServiceI;

@RestController
public class SocialMeliController {
    @Autowired
    SocialMeliServiceI socialMeliService;

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<MessageDTO> addFollow (
            @PathVariable("user_id") Long idFollower,
            @PathVariable("user_id_to_follow") Long idFollowed) {
        this.socialMeliService.follow(idFollower, idFollowed);
        MessageDTO outMessage = new MessageDTO("Seguimiento procesado con éxito");
        return new ResponseEntity(outMessage, HttpStatus.OK);
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_follow}")
    public ResponseEntity<MessageDTO> removeFollow (
            @PathVariable("user_id") Long idFollower,
            @PathVariable("user_id_to_follow") Long idFollowed) {
        this.socialMeliService.unfollow(idFollower, idFollowed);
        MessageDTO outMessage = new MessageDTO("Seguimiento eliminado con éxito");
        return new ResponseEntity(outMessage, HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<UserFollowersCountDTO> getFollowersCountOf (
            @PathVariable("user_id") Long idUser) {
        return new ResponseEntity(this.socialMeliService.getFollowersCount(idUser), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<UserFollowersDTO> getFollowersOf (
            @PathVariable("user_id") Long idUser,
            @RequestParam(value = "order", required = false) String orientation) {
        return new ResponseEntity(this.socialMeliService.getFollowers(idUser, orientation),
                HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowedBy (
            @PathVariable("user_id") Long idUser,
            @RequestParam(value = "order", required = false) String orientation) {
        return new ResponseEntity(this.socialMeliService.getFollowed(idUser, orientation),
                HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<MessageDTO> addNewPost(@RequestBody RequestPostDTO newPostReq) {
        this.socialMeliService.publish(newPostReq);
        MessageDTO outMessage = new MessageDTO("Publicación subida con éxito");
        return new ResponseEntity<>(outMessage, HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<UserPostsDTO> getRecentPostsByFollowed (
            @PathVariable("user_id") Long idUser,
            @RequestParam(value = "order", required = false) String orientation) {
        return new ResponseEntity(this.socialMeliService.getRecentPosts(idUser, orientation),
                HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<MessageDTO> publishPromo (
            @RequestBody RequestPromoPostDTO newPromoReq) {
        this.socialMeliService.publishPromo(newPromoReq);
        MessageDTO outMessage = new MessageDTO("Promoción subida con éxito");
        return new ResponseEntity(outMessage, HttpStatus.OK);
    }

    @GetMapping("/products/{user_id}/promo-post/count")
    public ResponseEntity<UserPromoCountDTO> getPromotionsCountOf (
            @PathVariable("user_id") Long idUser) {
        return new ResponseEntity(this.socialMeliService.getPromosCount(idUser), HttpStatus.OK);
    }
}
