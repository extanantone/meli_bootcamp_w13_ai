package com.example.SocialMeli.controller;

import com.example.SocialMeli.dto.*;
import com.example.SocialMeli.model.User;
import com.example.SocialMeli.service.ISocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {

    @Autowired
    ISocialService socialService;

    //US 0001  - SEGUIR A UN VENDEDOR
    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<?> followUser(
            @PathVariable int user_id,
            @PathVariable int user_id_to_follow
    ){
        socialService.followUser(user_id, user_id_to_follow);
        return ResponseEntity.status(HttpStatus.OK).body("todo OK");
    }

    //US 0002  - CANTIDAD DE USUARIOS QUE SIGUEN A UN VENDEDOR
    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<UserDataDto> getCountFollowers(
            @PathVariable int user_id
    ){
        return new ResponseEntity<>(socialService.countFollowers(user_id),HttpStatus.OK);
    }

    //US 0003  - LISTADO DE USUARIOS QUE SIGUEN A UN VENDEDOR
    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<UserFollowDto> getListFollowers(
            @PathVariable int user_id,
            @RequestParam(defaultValue = "name_asc") String order
    ){
        return new ResponseEntity<>(socialService.listFollowers(user_id, order),HttpStatus.OK);
    }

    //US 0004  - LISTADO DE VENDEDORES QUE UN USUARIO SIGUE
    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<UserFollowDto> getListFollowed(
            @PathVariable int user_id,
            @RequestParam(defaultValue = "name_asc") String order
    ){
        return new ResponseEntity<>(socialService.listFollowed(user_id, order),HttpStatus.OK);
    }

    //US 0005  - DAR DE ALTA UNA PUBLICACION
    @PostMapping("/products/post")
    public ResponseEntity<?> createPublication(@RequestBody PublicationDto publicationDto){
        socialService.postPublication(publicationDto);
        return ResponseEntity.status(HttpStatus.OK).body("todo OK");
    }

    //US 0006  - LISTAR PUBLICACIONES DE VENDEDORES QUE SIGO
    //@ResponseStatus
    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<UserDto> getProductsFollowed(
            @PathVariable int user_id,
            @RequestParam(defaultValue = "date_asc") String order
    ){
        return new ResponseEntity<>(socialService.getProductsFollowed(user_id, order), HttpStatus.OK);
    }

    //US 0007  - UNFOLLOW
    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<?> unfollowUser(
            @PathVariable int user_id,
            @PathVariable int user_id_to_unfollow
            ){
        socialService.unfollowUser(user_id, user_id_to_unfollow);
        return ResponseEntity.status(HttpStatus.OK).body("todo OK");
    }

    //US 0010  - PUBLICACION CON DESCUENTO
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> createPublicacionPromo(
            @RequestBody PublicationDto publicationDto
    ){
        socialService.postPublication(publicationDto);
        return ResponseEntity.status(HttpStatus.OK).body("todo OK");
    }

    //US 0011  - CANTIDAD DE PRODUCTOS EN PROMO
    @GetMapping("/products/{user_id}/promo-post/count")
    public ResponseEntity<UserCountPromoDto> getCountPromoPublications(
            @PathVariable int user_id
    ){
        return new ResponseEntity<>(socialService.countPromoPublications(user_id),HttpStatus.OK);
    }

    //US 0012  - LISTAR PUBLICACIONES EN PROMOCION
    @GetMapping("/products/{user_id}/list")
    public ResponseEntity<UserDto> getProductsPromo(
            @PathVariable int user_id,
            @RequestParam(defaultValue = "name_asc") String order
    ){
        return new ResponseEntity<>(socialService.getPublicationsPromo(user_id, order), HttpStatus.OK);
    }

    //OBTENER TODOS LOS USUARIOS CARGADOS DESDE EL ARCHIVO JSON
    @GetMapping("/users/getAll")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(socialService.getUsers(),HttpStatus.OK);
    }

    //OBTENER UN SOLO USUARIO POR SU ID
    @GetMapping("/users/getOne/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable int user_id){
        return new ResponseEntity<>(socialService.getUser(user_id),HttpStatus.OK);
    }
}
