package com.SocialMeli.Sprint1SocialMeli.Controller;


import com.SocialMeli.Sprint1SocialMeli.DTO.*;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Service.ISocialMeliService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialMeliController {

    final
    ISocialMeliService service;

    public SocialMeliController(ISocialMeliService service) {
        this.service = service;
    }

    @PostMapping(path = "/users/{user_id}/follow/{user_id_to_follow}") //US-01
    public ResponseEntity<MensajeExcepcionDTO> follow(@PathVariable Integer user_id,
                                                      @PathVariable Integer user_id_to_follow) {
        service.serviceFollow(user_id, user_id_to_follow);
        return new ResponseEntity<>(new MensajeExcepcionDTO("OK","El comprador "+user_id+" comenzo a seguir a vendedor "+user_id_to_follow), HttpStatus.OK);

    }

    @GetMapping("/users/{user_id}/followers/count") //US-02
    public ResponseEntity<CountSeguidoresDTO> contadorSeguidores(
            @PathVariable Integer user_id) {
        return new ResponseEntity<>(service.serviceCountVendedorFollowers(user_id), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/users/{user_id}/followers/list") //US-03 y US-08
    public ResponseEntity<SeguidoresDTO> listadoSeguidores(
            @PathVariable Integer user_id, @RequestParam(defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(service.serviceVendedorListFollowers(user_id, order), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/users/{user_id}/followed/list") //US-04 y US-08
    public ResponseEntity<SeguidosDTO> listadoSeguidos(
            @PathVariable Integer user_id, @RequestParam(defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(service.serviceCompradorListFollowed(user_id, order), HttpStatus.OK);
    }

    @PostMapping("/products/post") //US-05
    public ResponseEntity<MensajeExcepcionDTO> nuevaPublicacion(@RequestBody PublicacionDTO publi) throws Exception {
        service.serviceNewPost(publi);
        return new ResponseEntity<>(new MensajeExcepcionDTO("OK","NUEVA PUBLICACION CREADA"), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/products/post") //Prueba
    public List<Publicacion> listarPublicaciones() {
        return service.serviceListadoCompletoPublicaciones();
    }

    @ResponseBody
    @GetMapping("/products/followed/{user_id}/list") // US-06 y US-09
    public ResponseEntity<List<PublicacionesDTO>> listadoPublicaciones(@PathVariable Integer user_id,
                                                                       @RequestParam(defaultValue = "date_desc") String order) {
      return new ResponseEntity<>(service.serviceListadoPublicaciones(user_id, order), HttpStatus.OK);
    }

    @PostMapping(path = "/users/{user_id}/unfollow/{user_id_to_unfollow}") //US-07
    public ResponseEntity<MensajeExcepcionDTO> unFollow(@PathVariable Integer user_id,
                                                        @PathVariable Integer user_id_to_unfollow) {
        service.serviceUnFollow(user_id, user_id_to_unfollow);
        return new ResponseEntity<>(new MensajeExcepcionDTO("OK","El comprador "+user_id+" dejo de seguir a vendedor "+user_id_to_unfollow), HttpStatus.OK);
    }

}