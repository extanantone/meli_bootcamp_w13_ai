package com.socialMeli.socialMeli.controller;

import com.socialMeli.socialMeli.dto.PublicacionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IUsuarioController {
    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    ResponseEntity<?> follow(@PathVariable int user_id, @PathVariable int user_id_to_follow);

    @GetMapping("/users/{user_id}/followers/count")
    ResponseEntity<?> count(@PathVariable int user_id);

    @GetMapping("/users/{user_id}/followers/list")
    ResponseEntity<?> listarSeguidores(@PathVariable int user_id, @RequestParam(defaultValue = "") String order);

    @GetMapping("/users/{user_id}/followed/list")
    ResponseEntity<?> listarSeguidos(@PathVariable int user_id, @RequestParam(defaultValue = "") String order);

    @PostMapping("/products/post")
    ResponseEntity<?> darDeAltaPublicacion(@RequestBody PublicacionDTO publicacionDto);

    @GetMapping("/products/post/{user_id}")
    ResponseEntity<?> consultarPublicaciones(@PathVariable int user_id);

    @GetMapping("/products/followed/{user_id}/list")
    ResponseEntity<?> consultarPublicacionesDeUnUsuarioEn2Semanas(@PathVariable int user_id, @RequestParam(defaultValue = "") String order);

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    ResponseEntity<?> unfollow(@PathVariable int user_id, @PathVariable int user_id_to_unfollow);
}
