package com.example.socialmeli.controller;



import com.example.socialmeli.DTO.*;
import com.example.socialmeli.service.ISocialMeliService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
public class Controller {
    @Autowired
    ISocialMeliService SMservicio;

    //US 0001
    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<RespuestaDTO> seguir(@PathVariable int user_id, @PathVariable int user_id_to_follow) throws Error {
        RespuestaDTO rta = SMservicio.follow(user_id, user_id_to_follow);
        return new ResponseEntity<>(rta, HttpStatus.OK);
    }
    //US 0002
    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<FollowsDTO> contar(@PathVariable int user_id) throws Error {
        FollowsDTO cantidad = SMservicio.contar(user_id);
        return new ResponseEntity<>(cantidad, HttpStatus.OK);
    }
    //US 0003
    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<SeguidoresDTO> quienMeSigue(@PathVariable int user_id, @RequestParam(required = false) String order) throws Error {
        SeguidoresDTO seguidores = SMservicio.buscarSeguidores(user_id, order);
        return new ResponseEntity<>(seguidores, HttpStatus.OK);
    }
    //US 0004
    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<SeguidosDTO> aQuienSigo(@PathVariable int user_id, @RequestParam(required = false) String order) throws Error {
        SeguidosDTO seguidos = SMservicio.buscarSeguidos(user_id, order);
        return new ResponseEntity<>(seguidos, HttpStatus.OK);
    }
    //US 0007
    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<RespuestaDTO> unfolow(@PathVariable int user_id, @PathVariable int user_id_to_unfollow) throws Error {
        RespuestaDTO rta = SMservicio.unfollow(user_id, user_id_to_unfollow);
        return new ResponseEntity<>(rta, HttpStatus.OK);
    }
    /*
    Parte de Post de productos
     */

    //US 0005
    @PostMapping("/products/post")
    public ResponseEntity<RespuestaDTO> postear(@RequestBody PublicacionDTO pub) throws Error {
        RespuestaDTO rta = SMservicio.addPost(pub);
        return new ResponseEntity<>(rta, HttpStatus.OK);
    }
    //US 0006
    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<List<VendedoresDTO> > postsRecientes(@PathVariable int user_id, @RequestParam(required = false) String order) throws Error {
        List<VendedoresDTO>  posts = SMservicio.addPublicaciones(user_id, order);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    //US 00010
    @PostMapping("/products/promo-post")
    public ResponseEntity<RespuestaDTO> postearPromocion(@RequestBody PublicacionDTO pub) throws Error {
        RespuestaDTO rta = SMservicio.addPromocion(pub);
        return new ResponseEntity<>(rta, HttpStatus.OK);
    }
    //US 00011
    @GetMapping("/products/{user_id}/promo-post/count")
    public ResponseEntity<PromocionDTO> contarPromociones(@PathVariable int user_id) throws Error {
        PromocionDTO cantidad = SMservicio.contarPromocion(user_id);
        return new ResponseEntity<>(cantidad, HttpStatus.OK);
    }
    //US 00012
    @GetMapping("/products/{user_id}/list")
    public ResponseEntity<VendedoresDTO> postsConPromo(@PathVariable int user_id) throws Error {
        VendedoresDTO posts = SMservicio.publicacionesEnPromocion(user_id);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


}
