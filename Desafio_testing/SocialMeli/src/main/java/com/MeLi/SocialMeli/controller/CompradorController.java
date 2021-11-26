package com.MeLi.SocialMeli.controller;

import com.MeLi.SocialMeli.DTO.InfoSeguidosDTO;
import com.MeLi.SocialMeli.DTO.SeguimientoDTO;
import com.MeLi.SocialMeli.exception.NotFoundCompradorException;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.service.CompradorServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@RestController
public class CompradorController {

    @Autowired
    private CompradorServiceImplement compradorServiceImplement;

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<?> seguirVendedor(@PathVariable int user_id, @PathVariable int user_id_to_follow) throws NotFoundVendedorException, NotFoundCompradorException {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<InfoSeguidosDTO> listarSeguidos(@PathVariable int user_id, @RequestParam(defaultValue = "") String order) throws NotFoundVendedorException, NotFoundCompradorException {
        return new ResponseEntity<>(compradorServiceImplement.verSeguidos(user_id, order), HttpStatus.OK);
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<SeguimientoDTO> dejarSeguir(@PathVariable int user_id, @PathVariable int user_id_to_unfollow) throws NotFoundCompradorException, NotFoundVendedorException{
        return new ResponseEntity<>(compradorServiceImplement.dejarSeguir(user_id, user_id_to_unfollow), HttpStatus.OK);
    }
}
