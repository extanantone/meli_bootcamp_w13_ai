package com.MeLi.SocialMeli.controller;

import com.MeLi.SocialMeli.DTO.PublicacionDTO;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.exception.NotPubException;
import com.MeLi.SocialMeli.model.Publicacion;
import com.MeLi.SocialMeli.service.CompradorServiceImplement;
import com.MeLi.SocialMeli.service.PublicacionServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublicacionController{

    private PublicacionServiceImplement publicacionServiceImplement;

    public PublicacionController(PublicacionServiceImplement publicacionServiceImplement){
        this.publicacionServiceImplement = publicacionServiceImplement;
    }

    @PostMapping("/products/post")
    public ResponseEntity<Publicacion> addNewPost(@RequestBody PublicacionDTO post) throws NotPubException {
        return new ResponseEntity<>(publicacionServiceImplement.addNewPub(post), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<List<Publicacion>> getPublicaciones(@PathVariable int user_id) throws NotFoundVendedorException {
        return new ResponseEntity<>(publicacionServiceImplement.obtenerPublicaciones(user_id), HttpStatus.OK);
    }
}
