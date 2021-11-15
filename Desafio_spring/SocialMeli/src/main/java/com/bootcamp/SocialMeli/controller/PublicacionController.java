package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.publicacion.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.publicacion.PublicacionFollowedDTO;
import com.bootcamp.SocialMeli.dto.publicacion.PublicacionPromoCountDTO;
import com.bootcamp.SocialMeli.dto.publicacion.PublicacionPromoDTO;
import com.bootcamp.SocialMeli.exception.BadRequestException;
import com.bootcamp.SocialMeli.service.publicacion.IPublicacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PublicacionController {
    IPublicacionService iPublicacionService;

    public PublicacionController(IPublicacionService iPublicacionService) {
        this.iPublicacionService = iPublicacionService;
    }

    @PostMapping("/post")
    public ResponseEntity realizarPublicacion(@RequestBody PublicacionDTO publicacionDTO) throws BadRequestException {
        try {
            iPublicacionService.realizarPublicacion(publicacionDTO);
        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<PublicacionFollowedDTO> listaPublicacionesFollowed(
            @PathVariable Integer user_id,
            @RequestParam(defaultValue = "") String order)
            throws BadRequestException {
        PublicacionFollowedDTO publicacionFollowedDTO;
        try {
            if (order.equals("date_asc")) {
                publicacionFollowedDTO = iPublicacionService.listaPublicacionesFollowedAsc(user_id);
            } else if (order.equals("date_desc")) {
                publicacionFollowedDTO = iPublicacionService.listaPublicacionesFollowedDesc(user_id);
            } else {
                publicacionFollowedDTO = iPublicacionService.listaPublicacionesFollowed(user_id);
            }

        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(
                publicacionFollowedDTO,
                HttpStatus.OK
        );
    }

    @PostMapping("/promo-post")
    public ResponseEntity realizarPublicacionPromo(@RequestBody PublicacionPromoDTO publicacionPromoDTO) throws BadRequestException {
        try {
            iPublicacionService.realizarPublicacionPromo(publicacionPromoDTO);
        } catch (RuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{user_id}/promo-post/count")
    public ResponseEntity<PublicacionPromoCountDTO> contarPublicacionPromo(
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
    public ResponseEntity<List<PublicacionPromoDTO>> listaPublicacionesPromo(
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
