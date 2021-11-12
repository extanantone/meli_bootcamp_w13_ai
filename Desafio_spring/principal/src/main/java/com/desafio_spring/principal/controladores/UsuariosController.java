package com.desafio_spring.principal.controladores;

import com.desafio_spring.principal.dto.ConteosDTO;
import com.desafio_spring.principal.dto.ListaUsuariosDTO;
import com.desafio_spring.principal.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsuariosController {

    @Autowired
    private ServicioUsuarios serv;

    @GetMapping("")
    public ResponseEntity<String> saludo(){
        return new ResponseEntity("hola mundo", HttpStatus.OK);
    }


    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity seguir(@PathVariable("user_id") Integer userId,
                                         @PathVariable("user_id_to_follow") Integer userIdToFolow){
        serv.registrarSeguir(userId,userIdToFolow);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping("/{user_id}/unfollow/{user_id_to_follow}")
    public ResponseEntity dejarDeSeguir(@PathVariable("user_id") Integer userId,
                                         @PathVariable("user_id_to_follow") Integer userIdToFolow){
        serv.dejarDeSeguir(userId,userIdToFolow);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<ConteosDTO> conteoSeguidores(@PathVariable("user_id") Integer userId){
        return new ResponseEntity(serv.conteoSeguidores(userId), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<ListaUsuariosDTO> listaSeguidores(@PathVariable("user_id") Integer userId,
                                                            @RequestParam(value = "order", required = false) String order){
        return new ResponseEntity(serv.listaSeguidores(userId,order), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<ListaUsuariosDTO> listaSeguidos(@PathVariable("user_id") Integer userId,
                                                          @RequestParam(value = "order", required = false) String order){
        return new ResponseEntity(serv.listaSeguidos(userId,order), HttpStatus.OK);
    }
}
