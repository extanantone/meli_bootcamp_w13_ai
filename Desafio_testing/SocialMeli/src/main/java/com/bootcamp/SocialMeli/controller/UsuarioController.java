package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.usuario.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowerCountDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowerListDTO;
import com.bootcamp.SocialMeli.exception.BadRequestException;
import com.bootcamp.SocialMeli.service.usuario.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    IUsuarioService iUsuarioService;

    public UsuarioController(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }

    @PostMapping("/{user_id}/follow/{user_id_t_follow}")
    public ResponseEntity realizarFollow(@Valid
            @PathVariable Integer user_id, @PathVariable Integer user_id_t_follow)
            throws BadRequestException {
        try {
            iUsuarioService.realizarFollow(user_id, user_id_t_follow);
        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<FollowerCountDTO> contarFollowers(@Valid
            @PathVariable Integer user_id)
            throws BadRequestException {
        try {
            iUsuarioService.cantidadFollowers(user_id);
        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(
                iUsuarioService.cantidadFollowers(user_id),
                HttpStatus.OK
        );
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<FollowerListDTO> devolverListaFollowers(@Valid
            @PathVariable Integer user_id,
            @RequestParam(defaultValue = "") String order)
            throws BadRequestException {
        try {
            iUsuarioService.listaFollowers(user_id, order);
        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(
                iUsuarioService.listaFollowers(user_id, order), HttpStatus.OK
        );
    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<FollowedListDTO> devolverListaFollowed(@Valid
            @PathVariable Integer user_id,
            @RequestParam(defaultValue = "") String order)
            throws BadRequestException {

        try {
            iUsuarioService.listaFollowed(user_id, order);

        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(
                iUsuarioService.listaFollowed(user_id, order), HttpStatus.OK
        );
    }

    @PostMapping("/{user_id}/unfollow/{user_id_t_unfollow}")
    public ResponseEntity realizarUnfollow(@Valid
            @PathVariable Integer user_id, @PathVariable Integer user_id_t_unfollow)
            throws BadRequestException {
        try {
            iUsuarioService.realizarUnfollow(user_id, user_id_t_unfollow);
        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
