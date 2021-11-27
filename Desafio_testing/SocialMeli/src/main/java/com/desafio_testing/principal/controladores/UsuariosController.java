package com.desafio_testing.principal.controladores;

import com.desafio_testing.principal.dto.ConteosDTO;
import com.desafio_testing.principal.dto.ListaUsuariosDTO;
import com.desafio_testing.principal.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsuariosController {

    @Autowired
    private ServicioUsuarios serv;

    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<Object> seguir(@PathVariable("user_id") Integer userId,
                                         @PathVariable("user_id_to_follow") Integer userIdToFolow){
        serv.registrarSeguir(userId,userIdToFolow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{user_id}/unfollow/{user_id_to_follow}")
    public ResponseEntity<Object> dejarDeSeguir(@PathVariable("user_id") Integer userId,
                                         @PathVariable("user_id_to_follow") Integer userIdToFolow){
        serv.dejarDeSeguir(userId,userIdToFolow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<ConteosDTO> conteoSeguidores(@PathVariable("user_id") Integer userId){
        return new ResponseEntity<>(serv.conteoSeguidores(userId), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<ListaUsuariosDTO> listaSeguidores(@PathVariable("user_id") Integer userId,
                                                            @RequestParam(value = "order", required = false) String order){
        return new ResponseEntity<>(serv.listaSeguidores(userId,order), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<ListaUsuariosDTO> listaSeguidos(@PathVariable("user_id") Integer userId,
                                                          @RequestParam(value = "order", required = false) String order){
        return new ResponseEntity<>(serv.listaSeguidos(userId,order), HttpStatus.OK);
    }
}
