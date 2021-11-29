package com.SocialMeli.Sprint1SocialMeli.Controller;


import com.SocialMeli.Sprint1SocialMeli.DTO.*;
import com.SocialMeli.Sprint1SocialMeli.Service.ISocialMeliService;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SocialMeliController {


    final
    ISocialMeliService service;


    public SocialMeliController(ISocialMeliService service) {
        this.service = service;
    }

    @PostMapping(path = "/users/{compradorId}/follow/{vendedorId}")
    public ResponseEntity<ResponseDTO> follow(@PathVariable Integer compradorId,
                                              @PathVariable Integer vendedorId) {

        boolean b = service.addFollowed(compradorId, vendedorId);
        return new ResponseEntity(new ResponseDTO("Resultado " + b, "Vendedor " + vendedorId + " Seguido correctamente"), HttpStatus.OK);
    }


    @GetMapping(path = "/users/{vendedorId}/followers/count")
    public ResponseEntity<VendedorFollowesCountDTO> getVendedorFollowesCount(@PathVariable Integer vendedorId) {

        return new ResponseEntity(service.vendedorFollowesCount(vendedorId), HttpStatus.OK);
    }


    @GetMapping(path = "/users/{vendedorId}/followers/list")
    public ResponseEntity<VendedorFollowesCountDTO> getVendedorFollowesList(@PathVariable Integer vendedorId,
                                                                            @RequestParam(name = "order", required = false) String order) {

        return new ResponseEntity(service.vendedorFollowesList(vendedorId, order), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{compradoId}/followed/list")
    public ResponseEntity<VendedorFollowesCountDTO> getCompradorFollowerdList(@PathVariable Integer compradoId,
                                                                              @RequestParam(name = "order", required = false) String order) {

        return new ResponseEntity(service.compradorFollowedList(compradoId, order), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<ResponseDTO> createNewPublicacion(@Valid @RequestBody PublicacionDTO puDTO) {

        service.createNewPublicacion(puDTO);

        return new ResponseEntity(new ResponseDTO("200", "Su Producto se Publico Correctamente"), HttpStatus.OK);
    }


    @GetMapping(path = "/products/followed/{compradorId}/list")
    public ResponseEntity<VendedorFollowesCountDTO> getCompradorofVendedorPublicacionesList(@PathVariable Integer compradorId,
                                                                                            @RequestParam(name = "order", required = false) String order) {

        return new ResponseEntity(service.postByVendedorOfComprador(compradorId, order), HttpStatus.OK);
    }


    @GetMapping(path = "/users/{compradorId}/unfollow/{vendedorId}")
    public ResponseEntity<ResponseDTO> unFolowe(@PathVariable Integer compradorId,
                                                @PathVariable Integer vendedorId) {

        boolean unFollow = service.unFollow(compradorId, vendedorId);

        return new ResponseEntity(new ResponseDTO("Resultado " + unFollow, "Vendedor " + vendedorId + " Se dejo de seguir correctamente"), HttpStatus.OK);
    }


    @PostMapping("/products/promo-post")
    public ResponseEntity<ResponseDTO> createNewPublicacionConDescuento(@Valid @RequestBody PublicacionDTO puConDesDTO) {

        service.createNewPublicacion(puConDesDTO);

        return new ResponseEntity(new ResponseDTO("200", "Su Producto con descuento se Publico Correctamente"), HttpStatus.OK);
    }



    @GetMapping(path = "/products/{vendedorId}/promo-post/count")
    public ResponseEntity<PublicacionConDescuentoCountDTO> productoPromoCount(@PathVariable Integer vendedorId) {


        return new ResponseEntity(service.getProductoPromoCount(vendedorId), HttpStatus.OK);
    }

    @GetMapping(path = "/products/{vendedorId}/list")
    public ResponseEntity<VendedorPublicacionConDescuentoListDTO> VendedorProductDesc(@PathVariable Integer vendedorId) {


        return new ResponseEntity(service.getVendedorProductDesc(vendedorId), HttpStatus.OK);
    }

}
