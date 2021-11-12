package com.example.socialMeli.controller;

import com.example.socialMeli.dto.*;
import com.example.socialMeli.exceptions.UsuarioNoEncontradoError;
import com.example.socialMeli.service.ISocialMeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SocialMeliController {
    @Autowired
    ISocialMeliService SMservicio;
    @GetMapping("/cargar")
    public String prueba(){
        SMservicio.cargarDatos();
        return "Cargados con exito";
    }
    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<RespuestaSimpleDTO> seguir(@PathVariable int user_id, @PathVariable int user_id_to_follow) throws UsuarioNoEncontradoError {
        RespuestaSimpleDTO rta = SMservicio.seguir(user_id, user_id_to_follow);
        return new ResponseEntity<>(rta, HttpStatus.OK);
    }
    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<CantidadFollowsDTO> contar(@PathVariable int user_id) throws UsuarioNoEncontradoError {
        CantidadFollowsDTO cantidad = SMservicio.contar(user_id);
        return new ResponseEntity<>(cantidad, HttpStatus.OK);
    }
    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<SeguidoresDTO> quienMeSigue(@PathVariable int user_id) throws UsuarioNoEncontradoError {
        SeguidoresDTO seguidores = SMservicio.buscarSeguidores(user_id);
        return new ResponseEntity<>(seguidores, HttpStatus.OK);
    }
    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<SeguidosDTO> aQuienSigo(@PathVariable int user_id) throws UsuarioNoEncontradoError {
        SeguidosDTO seguidos = SMservicio.buscarSeguidos(user_id);
        return new ResponseEntity<>(seguidos, HttpStatus.OK);
    }
    @PostMapping("/products/post")
    public ResponseEntity<RespuestaSimpleDTO> postear(@RequestBody PublicacionDTO pub) throws UsuarioNoEncontradoError {
        RespuestaSimpleDTO rta = SMservicio.añadirPost(pub);
        return new ResponseEntity<>(rta, HttpStatus.OK);
    }
    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<List<PublicacionesVendedoresDTO> > postsRecientes(@PathVariable int user_id) throws UsuarioNoEncontradoError {
        List<PublicacionesVendedoresDTO>  posts = SMservicio.obtenerPublicaciones(user_id);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<RespuestaSimpleDTO> unfolow(@PathVariable int user_id, @PathVariable int user_id_to_unfollow) throws UsuarioNoEncontradoError {
        RespuestaSimpleDTO rta = SMservicio.dejarDeSeguir(user_id, user_id_to_unfollow);
        return new ResponseEntity<>(rta, HttpStatus.OK);
    }
}
