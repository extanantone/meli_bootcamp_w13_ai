package com.socialMeli.socialMeli.controller;
import com.socialMeli.socialMeli.dto.MensajeDTO;
import com.socialMeli.socialMeli.dto.PublicacionDTO;
import com.socialMeli.socialMeli.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class UsuarioController implements IUsuarioController {
    IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<?> follow(@PathVariable int user_id, @PathVariable int user_id_to_follow) {
        usuarioService.seguirUsuario(user_id, user_id_to_follow);
        return new ResponseEntity(new MensajeDTO("Usuario seguido"), HttpStatus.OK);
    }

    @Override
    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<?> count(@PathVariable int user_id) {
        return new ResponseEntity<>(usuarioService.contabilizarSeguidores(user_id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<?> listarSeguidores(@PathVariable int user_id, @RequestParam(defaultValue = "") String order) {
        return new ResponseEntity<>(usuarioService.mostrarSeguidoresDelUsuario(user_id, order), HttpStatus.OK);
    }

    @Override
    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<?> listarSeguidos(@PathVariable int user_id, @RequestParam(defaultValue = "") String order) {
        return new ResponseEntity<>(usuarioService.mostrarSeguidosDelUsuario(user_id, order), HttpStatus.OK);
    }

    @Override
    @PostMapping("/products/post")
    public ResponseEntity<?> darDeAltaPublicacion(@RequestBody PublicacionDTO publicacionDto) {
        usuarioService.agregarPublicacion(publicacionDto);
        return new ResponseEntity<>(new MensajeDTO("Se ha publicado correctamente"), HttpStatus.OK);
    }

    @Override
    @GetMapping("/products/post/{user_id}")
    public ResponseEntity<?> consultarPublicaciones(@PathVariable int user_id) {
        return new ResponseEntity<>(usuarioService.mostrarPublicaciones(user_id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<?> consultarPublicacionesDeUnUsuarioEn2Semanas(@PathVariable int user_id, @RequestParam(defaultValue = "") String order) {
        return new ResponseEntity(usuarioService.consultarPublicacionesDeUnUsuarioEn2Semanas(user_id, order), HttpStatus.OK);
    }

    @Override
    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<?> unfollow(@PathVariable int user_id, @PathVariable int user_id_to_unfollow) {
        usuarioService.dejarDeSeguirA(user_id, user_id_to_unfollow);
        return new ResponseEntity<>(new MensajeDTO("Usuario dejado de seguir"), HttpStatus.OK);
    }

}