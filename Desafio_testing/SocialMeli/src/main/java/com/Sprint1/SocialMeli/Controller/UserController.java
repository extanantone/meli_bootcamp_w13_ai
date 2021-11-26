package com.Sprint1.SocialMeli.Controller;

import com.Sprint1.SocialMeli.DTO.ResponseDTO;
import com.Sprint1.SocialMeli.DTO.UserFollowedsListDTO;
import com.Sprint1.SocialMeli.DTO.UserFollowersCountDTO;
import com.Sprint1.SocialMeli.DTO.UserFollowersListDTO;
import com.Sprint1.SocialMeli.Service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UserController {

    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    //US_0001
    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<ResponseDTO> seguirUsuario (@PathVariable("user_id") Integer userId, @PathVariable("user_id_to_follow") Integer userIdToFollow)
    {
        userService.agregarFollowed(userId, userIdToFollow);

        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO("Todo OK"),
                HttpStatus.OK);
    }

    //US_0002
    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<UserFollowersCountDTO> obtenerCantSeguidores (@PathVariable("user_id") Integer userId)
    {
        return new ResponseEntity<UserFollowersCountDTO>(
                userService.obtenerUserFollowersCount(userId),
                HttpStatus.OK);
    }

    //US_0003 y US_0008
    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<UserFollowersListDTO> obtenerListaSeguidores (@PathVariable("user_id") Integer userId, @RequestParam(value = "order", required = false) String order)
    {
        return new ResponseEntity<UserFollowersListDTO>(
                userService.obtenerUserFollowersList(userId, order),
                HttpStatus.OK);
    }

    //US_0004 y US_0008
    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<UserFollowedsListDTO> obtenerListaSeguidos (@PathVariable("user_id") Integer userId, @RequestParam(value = "order", required = false) String order)
    {
        return new ResponseEntity<UserFollowedsListDTO>(
                userService.obtenerUserFollowedsList(userId, order),
                HttpStatus.OK);
    }

    //US_0007
    @PostMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<ResponseDTO> dejarDeSeguirUsuario (@PathVariable("user_id") Integer userId, @PathVariable("user_id_to_unfollow") Integer userIdToUnfollow)
    {
        userService.quitarFollowed(userId, userIdToUnfollow);

        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO("Todo OK"),
                HttpStatus.OK);
    }
}
