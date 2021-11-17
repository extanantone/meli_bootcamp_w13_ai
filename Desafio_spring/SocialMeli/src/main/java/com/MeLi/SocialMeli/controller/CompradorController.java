package com.MeLi.SocialMeli.controller;

import com.MeLi.SocialMeli.DTO.InfoSeguidosDTO;
import com.MeLi.SocialMeli.DTO.SeguimientoDTO;
import com.MeLi.SocialMeli.exception.NotFoundCompradorException;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.service.CompradorServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CompradorController {

    private CompradorServiceImplement compradorServiceImplement;

    public CompradorController(CompradorServiceImplement compradorServiceImplement){
        this.compradorServiceImplement = compradorServiceImplement;
    }

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<SeguimientoDTO> seguirVendedor(@PathVariable int user_id, @PathVariable int user_id_to_follow) throws NotFoundVendedorException, NotFoundCompradorException {
        return new ResponseEntity<>(compradorServiceImplement.seguir(user_id,user_id_to_follow), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<InfoSeguidosDTO> listarSeguidos(@PathVariable int user_id) throws NotFoundVendedorException, NotFoundCompradorException {
        return new ResponseEntity<>(compradorServiceImplement.verSeguidos(user_id), HttpStatus.OK);
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<SeguimientoDTO> dejarSeguir(@PathVariable int user_id, @PathVariable int user_id_to_unfollow) throws NotFoundCompradorException, NotFoundVendedorException{
        return new ResponseEntity<>(compradorServiceImplement.dejarSeguir(user_id, user_id_to_unfollow), HttpStatus.OK);
    }
}
