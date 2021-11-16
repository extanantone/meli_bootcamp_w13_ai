package com.Sprint1.SocialMeli.Controller;

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

    //TODO: Que un usuario no se pueda seguir a si mismo
    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<String> seguirUsuario (@PathVariable("user_id") Integer userId, @PathVariable("user_id_to_follow") Integer userIdToFollow)
    {
        if (userId == null || userIdToFollow == null){
            return new ResponseEntity<>(
                    "Debe indicar los ID del usuario actual y del usuario a seguir.",
                    HttpStatus.BAD_REQUEST);
        }

        if (!userService.existeUsuario(userId)){
            return new ResponseEntity<>(
                    "El usuario con ID: " + userId + " no existe.",
                    HttpStatus.BAD_REQUEST);
        }

        if (!userService.existeUsuario(userIdToFollow)){
            return new ResponseEntity<>(
                    "El usuario con ID: " + userIdToFollow + " no existe.",
                    HttpStatus.BAD_REQUEST);
        }

        if (userService.existeFollowed(userId, userIdToFollow)){
            return new ResponseEntity<>(
                    "El usuario " + userId + " ya sigue al usuario " + userIdToFollow,
                    HttpStatus.BAD_REQUEST);
        }

        //TODO: Para informe, decir que sólo se pueden seguir a vendedores
        if (!userService.obtenerUsuario(userIdToFollow).getIsSeller()){
            return new ResponseEntity<>(
                    "El usuario a seguir (" + userIdToFollow + ") no es un usuario vendedor",
                    HttpStatus.BAD_REQUEST);
        }

        userService.agregarFollowed(userId, userIdToFollow);

        return new ResponseEntity<>(
                "Todo OK",
                HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<UserFollowersCountDTO> obtenerCantSeguidores (@PathVariable("user_id") Integer userId)
    {
        //TODO: Agregar validaciones

        return new ResponseEntity<UserFollowersCountDTO>(
                userService.obtenerUserFollowersCount(userId),
                HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<UserFollowersListDTO> obtenerListaSeguidores (@PathVariable("user_id") Integer userId)
    {
        //TODO: Agregar validaciones

        return new ResponseEntity<UserFollowersListDTO>(
                userService.obtenerUserFollowersList(userId),
                HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<UserFollowedsListDTO> obtenerListaSeguidos (@PathVariable("user_id") Integer userId)
    {
        //TODO: Agregar validaciones

        return new ResponseEntity<UserFollowedsListDTO>(
                userService.obtenerUserFollowedsList(userId),
                HttpStatus.OK);
    }














    @GetMapping("/prueba")
    public ResponseEntity<HashMap> obtenerPrueba ()
    {

        return new ResponseEntity<HashMap>(
                userService.prueba(),
                HttpStatus.OK);
    }

}
