package com.MeLi.SocialMeli.controller;

import com.MeLi.SocialMeli.DTO.PubVendedoresDTO;
import com.MeLi.SocialMeli.DTO.PublicacionDTO;
import com.MeLi.SocialMeli.exception.NotFoundCompradorException;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.exception.NotPubException;
import com.MeLi.SocialMeli.mapper.PublicacionMapper;
import com.MeLi.SocialMeli.model.Publicacion;
import com.MeLi.SocialMeli.service.CompradorServiceImplement;
import com.MeLi.SocialMeli.service.PublicacionServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class PublicacionController{

    private PublicacionServiceImplement publicacionServiceImplement;

    public PublicacionController(PublicacionServiceImplement publicacionServiceImplement){
        this.publicacionServiceImplement = publicacionServiceImplement;
    }

    @PostMapping("/products/post")
    public ResponseEntity<Publicacion> addNewPost(@RequestBody @Valid PublicacionDTO post) throws NotPubException {

        return new ResponseEntity<>(publicacionServiceImplement.addNewPub(post), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<PubVendedoresDTO> getPublicaciones(@PathVariable int user_id, @RequestParam(required = false) String order) throws NotFoundVendedorException, NotFoundCompradorException {
        return new ResponseEntity<PubVendedoresDTO>(publicacionServiceImplement.obtenerPublicaciones(user_id, order), HttpStatus.OK);
    }
}
