package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowerCountDTO;
import com.bootcamp.SocialMeli.dto.FollowerListDTO;
import com.bootcamp.SocialMeli.exception.handler.BadRequestException;
import com.bootcamp.SocialMeli.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    IUsuarioService iUsuarioService;

    public UsuarioController(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity realizarFollow(
            @PathVariable Integer userId, @PathVariable Integer userIdToFollow)
            throws BadRequestException {
        try {
            iUsuarioService.realizarFollow(userId, userIdToFollow);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<FollowerCountDTO> contarFollowers(
            @PathVariable Integer user_id)
            throws BadRequestException {
        try {
            iUsuarioService.cantidadFollowers(user_id);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                iUsuarioService.cantidadFollowers(user_id),
                HttpStatus.OK
        );
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<FollowerListDTO> devolverListaFollowers(
            @PathVariable Integer user_id)
            throws BadRequestException {
        try {
            iUsuarioService.listaFollowers(user_id);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                iUsuarioService.listaFollowers(user_id), HttpStatus.OK
        );
    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<FollowedListDTO> devolverListaFollowed(
            @PathVariable Integer user_id)
            throws BadRequestException {
        try {
            iUsuarioService.listaFollowed(user_id);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                iUsuarioService.listaFollowed(user_id), HttpStatus.OK
        );
    }
}
