package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.publicacion.*;
import com.bootcamp.SocialMeli.exception.BadRequestException;
import com.bootcamp.SocialMeli.service.publicacion.IPublicacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class PublicacionController {
    IPublicacionService iPublicacionService;

    public PublicacionController(IPublicacionService iPublicacionService) {
        this.iPublicacionService = iPublicacionService;
    }

    @PostMapping("/post")
    public ResponseEntity realizarPublicacion(@Valid @RequestBody PublicacionDTO publicacionDTO) throws BadRequestException {
        try {
            iPublicacionService.realizarPublicacion(publicacionDTO);
        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<PublicacionFollowedDTO> listaPublicacionesFollowed(@Valid
            @PathVariable Integer user_id,
            @RequestParam(defaultValue = "") String order)
            throws BadRequestException {
        try {
            iPublicacionService.listaPublicacionesFollowed(user_id, order);

        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(
                iPublicacionService.listaPublicacionesFollowed(user_id, order),
                HttpStatus.OK
        );
    }

    @PostMapping("/promo-post")
    public ResponseEntity realizarPublicacionPromo(@Valid @RequestBody PublicacionPromoDTO publicacionPromoDTO) throws BadRequestException {
        try {
            iPublicacionService.realizarPublicacionPromo(publicacionPromoDTO);
        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{user_id}/promo-post/count")
    public ResponseEntity<PublicacionPromoCountDTO> contarPublicacionPromo(@Valid
            @PathVariable Integer user_id)
            throws BadRequestException {
        try {
            iPublicacionService.cantidadPublicacionPromo(user_id);
        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(
                iPublicacionService.cantidadPublicacionPromo(user_id),
                HttpStatus.OK
        );
    }

    @GetMapping("/{user_id}/list")
    public ResponseEntity<PublicacionPromoListDTO> listaPublicacionesPromo(@Valid
            @PathVariable Integer user_id)
            throws BadRequestException {
        try {
            iPublicacionService.listaPublicacionesPromo(user_id);
        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(
                iPublicacionService.listaPublicacionesPromo(user_id),
                HttpStatus.OK
        );
    }
}
