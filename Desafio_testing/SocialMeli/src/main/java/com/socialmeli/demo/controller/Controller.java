package com.socialmeli.demo.controller;


import com.socialmeli.demo.dto.*;
import com.socialmeli.demo.exceptions.Error;
import com.socialmeli.demo.service.ISocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;




@RestController
public class Controller {
    @Autowired
    ISocialService SMservicio;

    //US 0001
    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<RespuestaDTO> seguir(@Valid @PathVariable Integer user_id, @Valid @PathVariable Integer user_id_to_follow) throws Error {
        RespuestaDTO Resp = SMservicio.follow(user_id, user_id_to_follow);
        return new ResponseEntity<>(Resp, HttpStatus.OK);
    }
    //US 0002
    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<FollowsDTO> contar(@PathVariable @Valid Integer user_id) throws Error {
        FollowsDTO cantidad = SMservicio.contar(user_id);
        return new ResponseEntity<>(cantidad, HttpStatus.OK);
    }
    //US 0003
    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<SeguidoresDTO> quienMeSigue(@PathVariable Integer user_id, @RequestParam(required = false) String order) throws Error {
        SeguidoresDTO seguidores = SMservicio.buscarSeguidores(user_id, order);
        return new ResponseEntity<>(seguidores, HttpStatus.OK);
    }
    //US 0004
    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<SeguidoresDTO> aQuienSigo( @Valid @PathVariable Integer user_id, @RequestParam(required = false) String order) throws Error {
        SeguidoresDTO seguidos = SMservicio.buscarSeguidos(user_id, order);
        return new ResponseEntity<>(seguidos, HttpStatus.OK);
    }
    //US 0007
    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<RespuestaDTO> unfolow(@Valid @PathVariable Integer user_id, @PathVariable Integer user_id_to_unfollow) throws Error {
        RespuestaDTO Resp = SMservicio.unfollow(user_id, user_id_to_unfollow);
        return new ResponseEntity<>(Resp, HttpStatus.OK);
    }
    /*
    Parte de Post de productos
     */

    //US 0005
    @PostMapping("/products/post")
    public ResponseEntity<RespuestaDTO> postear(@Valid @RequestBody PublicacionDTO pub) throws Error {
        RespuestaDTO Resp = SMservicio.addPost(pub);
        return new ResponseEntity<>(Resp, HttpStatus.OK);
    }
    //US 0006
    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<List<VendedoresDTO> > postsRecientes(@Valid @PathVariable Integer user_id, @RequestParam(required = false) String order) throws Error {
        List<VendedoresDTO>  posts = SMservicio.addPublicaciones(user_id, order);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    //US 00010
    @PostMapping("/products/promo-post")
    public ResponseEntity<RespuestaDTO> postearPromocion( @Valid @RequestBody PublicacionDTO pub) throws Error {
        RespuestaDTO Resp = SMservicio.addPromocion(pub);
        return new ResponseEntity<>(Resp, HttpStatus.OK);
    }
    //US 00011
    @GetMapping("/products/{user_id}/promo-post/count")
    public ResponseEntity<PromocionDTO> contarPromociones(@Valid @PathVariable Integer user_id) throws Error {
        PromocionDTO cantidad = SMservicio.contarPromocion(user_id);
        return new ResponseEntity<>(cantidad, HttpStatus.OK);
    }
    //US 00012
    @GetMapping("/products/{user_id}/list")
    public ResponseEntity<VendedoresDTO> postsConPromo(@Valid @PathVariable Integer user_id) throws Error {
        VendedoresDTO posts = SMservicio.publicacionesEnPromocion(user_id);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


}
