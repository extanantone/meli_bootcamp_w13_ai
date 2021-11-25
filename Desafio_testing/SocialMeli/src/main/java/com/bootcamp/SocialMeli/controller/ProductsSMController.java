package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.request.PromocionDTO;
import com.bootcamp.SocialMeli.dto.PublicacionDTO;
import com.bootcamp.SocialMeli.service.ISocialMeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

/**
 * Controlador que gestiona los endpoints vinculados con los posteos y productos.
 */
@RestController
@RequestMapping("/products")
public class ProductsSMController {

    @Autowired
    private ISocialMeliService socialMeliService;

    @PostMapping("/post")
    public ResponseEntity<?> crearPublicacion(@Valid @RequestBody PublicacionDTO post){
        return new ResponseEntity<>(this.socialMeliService.crearPublicacion(post), HttpStatus.OK);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<?> getPublicacionesSeguidos(@Valid
                                                      @Positive(message = "El ID debe ser mayor a cero.")
                                                      @NotNull(message = "El ID no puede estar vacío.")
                                                      @PathVariable("user_id") Integer userId,

                                                      @RequestParam(value = "order", required = false) String order){
        if(order == null){
            return new ResponseEntity<>(this.socialMeliService.getPublicacionesSeguidos(userId), HttpStatus.OK);
        }
        return new ResponseEntity<>(this.socialMeliService.getPublicacionesSeguidos(userId, order), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> publicarPromocion(@Valid @RequestBody PromocionDTO promo){
        return new ResponseEntity<>(this.socialMeliService.crearPublicacion(promo), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/promo-post/count")
    public ResponseEntity<?> getCantPromociones(@Valid
                                                @Positive(message = "El ID debe ser mayor a cero.")
                                                @NotNull(message = "El ID no puede estar vacío.")
                                                @PathVariable("user_id") Integer userId){
        return new ResponseEntity<>(this.socialMeliService.getCantPromociones(userId), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/list")
    public ResponseEntity<?> getProductosEnPromocion(@Valid
                                                     @Positive(message = "El ID debe ser mayor a cero.")
                                                     @NotNull(message = "El ID no puede estar vacío.")
                                                     @PathVariable("user_id") Integer userId,
                                                     @RequestParam(value = "order", required = false) String order){
        if(order == null){
            return new ResponseEntity<>(this.socialMeliService.getProductosEnPromocion(userId), HttpStatus.OK);
        }
        return new ResponseEntity<>(this.socialMeliService.getProductosEnPromocion(userId, order), HttpStatus.OK);
    }

}
