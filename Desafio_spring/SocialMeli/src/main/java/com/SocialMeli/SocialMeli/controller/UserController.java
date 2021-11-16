package com.SocialMeli.SocialMeli.controller;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users/followed/create")
    public UserDTO createBuyers(@RequestBody UserDTO user){
        return userService.createBuyers(user);
    }

    @PostMapping("users/followers/create")
    public UserDTO createSellers(@RequestBody UserDTO user){
        return userService.createSellers(user);
    }

    @PostMapping("users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<String> followUser(@PathVariable Integer user_id, @PathVariable Integer user_id_to_follow) {
        Boolean statusFollow = userService.followUser(user_id,user_id_to_follow);
        if( statusFollow )
            return new ResponseEntity<>("Usuarios seguidos.", HttpStatus.OK);

        return new ResponseEntity<>("Los usuarios no pueden seguirse.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("users/{user_id}/followers/count")
    public FollowersCountDTO followersCount(@PathVariable Integer user_id){
        return userService.followersCount(user_id);
    }

    @GetMapping("/users/{user_id}/followers/list")
    public SellersDTO followersList(@PathVariable Integer user_id){
        return userService.followersList(user_id);
    }

    @GetMapping("/users/{user_id}/followed/list")
    public BuyersDTO followedList(@PathVariable Integer user_id){
        return userService.followedList(user_id);
    }

    @PostMapping("products/post")
    public ResponseEntity<String> createPost(@RequestBody PostUserDTO post){

        Boolean band = userService.createPost(post);

        if( band )
            return new ResponseEntity<String>("Post guardado con éxito.", HttpStatus.OK);

        return new ResponseEntity<String>("Ha ocurrido un error al guardar el post.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public PostListDTO postList(@PathVariable Integer user_id){
        String order = "date_desc";
        return userService.postList(user_id, order);
    }

    @PostMapping("users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<String> unfollowUser(@PathVariable Integer user_id, @PathVariable Integer user_id_to_unfollow) {
        Boolean statusUnfollow = userService.unfollowUser(user_id,user_id_to_unfollow);
        if( statusUnfollow )
            return new ResponseEntity<>("Los usuarios se han dejado de seguir.", HttpStatus.OK);

        return new ResponseEntity<>("Ha ocurrido un error en la acción.", HttpStatus.BAD_REQUEST);
    }

    //public ResponseEntity<ListadoSeguidoresDTO> listadoSeguidores(
    //            @PathVariable Integer user_id, @RequestParam(defaultValue = "name_asc") String order)
    @GetMapping(value ="/users/{userId}/followed/list", params = {"order"})
    public BuyersDTO followedListSorted(@PathVariable Integer userId, @RequestParam("order") String order){
        return userService.followedListSorted(userId, order);
    }

    @GetMapping(value ="/users/{userId}/followers/list", params = {"order"})
    public SellersDTO followersListSorted(@PathVariable Integer userId, @RequestParam("order") String order){
        return userService.followersListSorted(userId, order);
    }

    @GetMapping(value = "/products/followed/{user_id}/list", params = {"order"})
    public PostListDTO postListParam(@PathVariable Integer user_id, @RequestParam("order") String order){
        System.out.println("------------>Order------>"+order);

        return userService.postList(user_id, order);
    }
}
