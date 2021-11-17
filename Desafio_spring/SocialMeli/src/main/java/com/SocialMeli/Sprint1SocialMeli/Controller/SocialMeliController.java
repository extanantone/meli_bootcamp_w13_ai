package com.SocialMeli.Sprint1SocialMeli.Controller;


import com.SocialMeli.Sprint1SocialMeli.DTO.CompradorDTO;
import com.SocialMeli.Sprint1SocialMeli.DTO.PublicacionDTO;
import com.SocialMeli.Sprint1SocialMeli.DTO.VendedorFollowesCountDTO;
import com.SocialMeli.Sprint1SocialMeli.Service.ISocialMeliService;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SocialMeliController {


    final
    ISocialMeliService service;


    public SocialMeliController(ISocialMeliService service) {
        this.service = service;
    }

    @PostMapping(path = "/users/{compradorId}/follow/{vendedorId}")
    public ResponseEntity<?> follow(@PathVariable Integer compradorId,
                                    @PathVariable Integer vendedorId) {

        service.addFollowed(compradorId, vendedorId);
        return new ResponseEntity("Se ha seguido Comprador", HttpStatus.OK);
    }


    @GetMapping(path = "/comprador/{idComprador}")
    public ResponseEntity<CompradorDTO> getComprador(@PathVariable Integer idComprador) {

        return new ResponseEntity(service.getCompradorFindId(idComprador), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{vendedorId}/followers/count")
    public ResponseEntity<VendedorFollowesCountDTO> getVendedorFollowesCount(@PathVariable Integer vendedorId) {

        return new ResponseEntity(service.vendedorFollowesCount(vendedorId), HttpStatus.OK);
    }


    @GetMapping(path = "/users/{vendedorId}/followers/list")
    public ResponseEntity<VendedorFollowesCountDTO> getVendedorFollowesList(@PathVariable Integer vendedorId) {

        return new ResponseEntity(service.vendedorFollowesList(vendedorId), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{compradoId}/followed/list")
    public ResponseEntity<VendedorFollowesCountDTO> getCompradorFollowerdList(@PathVariable Integer compradoId) {

        return new ResponseEntity(service.compradorFollowedList(compradoId), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity createNewPublicacion(@RequestBody PublicacionDTO puDTO) {

        service.createNewPublicacion(puDTO);

        return new ResponseEntity("se creo correctamente", HttpStatus.OK);
    }


    @GetMapping(path = "/products/followed/{compradorId}/list")
    public ResponseEntity<VendedorFollowesCountDTO> getCompradorofVendedorPublicacionesList(@PathVariable Integer compradorId) {

        return new ResponseEntity(service.postByVendedorOfComprador(compradorId), HttpStatus.OK);
    }


    @GetMapping(path = "/users/{compradorId}/unfollow/{vendedorId}")
    public ResponseEntity unFolowe(@PathVariable Integer compradorId,
                                   @PathVariable Integer vendedorId) {

          service.unFollow(compradorId, vendedorId);
        return new ResponseEntity("Se dejo de seguir correctamente ", HttpStatus.OK);
    }


}
