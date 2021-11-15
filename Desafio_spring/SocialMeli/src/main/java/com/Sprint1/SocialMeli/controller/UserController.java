package com.Sprint1.SocialMeli.controller;


import com.Sprint1.SocialMeli.dto.FollowSellerDTO;
import com.Sprint1.SocialMeli.dto.FollowerDTO;
import com.Sprint1.SocialMeli.model.User;
import com.Sprint1.SocialMeli.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/socialMeli/users")
public class UserController {
    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


//================               US 0001           ================================
//      US 0001: Poder realizar la acción de "Follow" (seguir) a un determinado vendedor
    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<?> followSeller(
            @PathVariable int user_id,
            @PathVariable int user_id_to_follow){
        this.userService.followSeller( user_id, user_id_to_follow);
        return new ResponseEntity<>( HttpStatus.OK);
    }


//================               US 0002           ================================
//      US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<?> followerCount (
            @PathVariable int user_id){
//        this.userService.followerCount(user_id);
        return new ResponseEntity<>( this.userService.followerCount(user_id), HttpStatus.OK);
    }


//================               US 0003            ================================
//      Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<?> followerList (
            @PathVariable int user_id){
//        this.userService.followerCount(user_id);
        return new ResponseEntity<>( this.userService.followerList(user_id), HttpStatus.OK);
    }
}
