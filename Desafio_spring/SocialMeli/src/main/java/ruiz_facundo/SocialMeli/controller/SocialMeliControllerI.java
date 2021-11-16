package ruiz_facundo.SocialMeli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruiz_facundo.SocialMeli.dto.*;

public interface SocialMeliControllerI {
    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    ResponseEntity<MessageDTO> addFollow (
            @PathVariable("user_id") Long idFollower,
            @PathVariable("user_id_to_follow") Long idFollowed);

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_follow}")
    ResponseEntity<MessageDTO> removeFollow (
            @PathVariable("user_id") Long idFollower,
            @PathVariable("user_id_to_follow") Long idFollowed);

    @GetMapping("/users/{user_id}/followers/count")
    ResponseEntity<UserFollowersCountDTO> getFollowersCountOf (
            @PathVariable("user_id") Long idUser);

    @GetMapping("/users/{user_id}/followers/list")
    ResponseEntity<UserFollowersDTO> getFollowersOf (
            @PathVariable("user_id") Long idUser,
            @RequestParam(value = "order", required = false) String criteria);

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowedBy (
            @PathVariable("user_id") Long idUser,
            @RequestParam(value = "order", required = false) String orientation);

    @PostMapping("/products/post")
    public ResponseEntity<MessageDTO> addNewPost(@RequestBody RequestPostDTO newPostReq);

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<UserPostsDTO> getRecentPostsByFollowed (
            @PathVariable("user_id") Long idUser,
            @RequestParam(value = "order", required = false) String orientation);

    @PostMapping("/products/promo-post")
    public ResponseEntity<MessageDTO> publishPromo (@RequestBody RequestPromotionDTO newPromoReq);

    @GetMapping("/products/{user_id}/promo-post/count")
    public ResponseEntity<UserPromoCountDTO> getPromotionsCountOf (
            @PathVariable("user_id") Long idUser);

    @GetMapping("/products/{user_id}/list")
    public ResponseEntity<UserNamePostsDTO> getPromotionsOf(
            @PathVariable("user_id") Long idUser,
            @RequestParam(value = "order", required = false) String orientation);
}
