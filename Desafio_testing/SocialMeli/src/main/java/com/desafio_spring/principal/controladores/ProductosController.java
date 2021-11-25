package com.desafio_spring.principal.controladores;

import com.desafio_spring.principal.dto.ConteosDTO;
import com.desafio_spring.principal.dto.ListaPublicacionesDTO;
import com.desafio_spring.principal.dto.PublicacionesDTO;
import com.desafio_spring.principal.servicios.ServicioPublicaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductosController {

    @Autowired
    @Qualifier("ServicioPublicaciones")
    private ServicioPublicaciones serv;

    @GetMapping("")
    public ResponseEntity<String> saludo(){
        return new ResponseEntity<>("hola mundo", HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Object> crearPost(@Valid @RequestBody PublicacionesDTO entrada){
        serv.crearPublicacion(entrada);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/promo-post")
    public ResponseEntity<Object> crearPostPromo(@Valid @RequestBody PublicacionesDTO entrada){
        serv.crearPublicacionPromo(entrada);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{user_id}/promo-post/count")
    public ResponseEntity<ConteosDTO> conteoPromoPost(@PathVariable("user_id") Integer userId){

        return new ResponseEntity<>(serv.contarPublicacionesPromo(userId), HttpStatus.OK);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<ListaPublicacionesDTO> consultarPublicaciones(@PathVariable("user_id") Integer userId,
                                                               @RequestParam(value="order", required = false) String order){
        return new ResponseEntity<>(new ListaPublicacionesDTO(userId, null,serv.consultarPublicaciones(userId,order)), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/list")
    public ResponseEntity<ListaPublicacionesDTO> consultarPublicacionesPromo(@PathVariable("user_id") Integer userId,
                                                               @RequestParam(value="order", required = false) String order){
        return new ResponseEntity<>(serv.obtenerPubsPromocion(userId,order), HttpStatus.OK);
    }

}
