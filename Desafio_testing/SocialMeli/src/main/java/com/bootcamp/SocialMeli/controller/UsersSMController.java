package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.UsuarioDTO;
import com.bootcamp.SocialMeli.service.ISocialMeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

/**
 * Controlador que maneja los endpoints relacionados con los usuarios.
 */
@RestController
@RequestMapping("/users")
@Validated
public class UsersSMController {

    @Autowired
    private ISocialMeliService socialMeliService;

    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<?> followVendedor(@Positive(message = "El ID debe ser mayor a cero.")
                                            @NotNull(message = "El ID no puede estar vacío.")
                                            @PathVariable("user_id") Integer userId,
                                            @Positive(message = "El ID debe ser mayor a cero.")
                                            @NotNull(message = "El ID no puede estar vacío.")
                                            @PathVariable("user_id_to_follow") Integer userIdToFollow){
        return new ResponseEntity<>(this.socialMeliService.followVendedor(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<?> getCantSeguidores(@Positive(message = "El ID debe ser mayor a cero.")
                                               @NotNull(message = "El ID no puede estar vacío.")
                                               @PathVariable("user_id") Integer userId){
        return new ResponseEntity<>(this.socialMeliService.getCantSeguidores(userId), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<?> getSeguidores(@Positive(message = "El ID debe ser mayor a cero.")
                                           @NotNull(message = "El ID no puede estar vacío.")
                                           @PathVariable("user_id") Integer userId,
                                           @Pattern(regexp = "name_asc|name_desc", message = "Los tipos validos de ordenamiento son name_asc y name_desc")
                                           @RequestParam(value = "order", required = false) String order){
        if(order == null){
            return new ResponseEntity<>(this.socialMeliService.getSeguidores(userId), HttpStatus.OK);
        }
        return new ResponseEntity<>(this.socialMeliService.getSeguidores(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<?> getVendedoresSeguidos(@Positive(message = "El ID debe ser mayor a cero.")
                                                   @NotNull(message = "El ID no puede estar vacío.")
                                                   @PathVariable("user_id") Integer userId,
                                                   @Pattern(regexp = "name_asc|name_desc", message = "Los tipos validos de ordenamiento son name_asc y name_desc")
                                                   @RequestParam(value = "order", required = false) String order){
        if(order == null){
            return new ResponseEntity<>(this.socialMeliService.getVendedoresSeguidos(userId), HttpStatus.OK);
        }
        return new ResponseEntity<>(this.socialMeliService.getVendedoresSeguidos(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<?> unfollowVendedor(@Positive(message = "El ID debe ser mayor a cero.")
                                              @NotNull(message = "El ID no puede estar vacío.")
                                              @PathVariable("user_id") Integer userId,
                                              @Positive(message = "El ID debe ser mayor a cero.")
                                              @NotNull(message = "El ID no puede estar vacío.")
                                              @PathVariable("user_id_to_unfollow") Integer userIdToUnfollow){
        return new ResponseEntity<>(this.socialMeliService.unfollowVendedor(userId, userIdToUnfollow), HttpStatus.OK);
    }

    /**
     * Endpoint para crear un nuevo usuario, sin seguidores, sin seguidos, ni publicaciones.
     * @param usuario DTO con el ID y nombre del usuario a crear
     * @return
     */
    @PostMapping("/new")
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody UsuarioDTO usuario){
        return new ResponseEntity<>(this.socialMeliService.crearUsuario(usuario), HttpStatus.OK);
    }

}
