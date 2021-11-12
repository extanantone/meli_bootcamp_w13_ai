package com.example.socialMeli.controller;

import com.example.socialMeli.dto.CantidadFollowsDTO;
import com.example.socialMeli.dto.RespuestaSimpleDTO;
import com.example.socialMeli.exceptions.UsuarioNoEncontradoError;
import com.example.socialMeli.service.ISocialMeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialMeliController {
    @Autowired
    ISocialMeliService SMservicio;
    @GetMapping("/cargar")
    public String prueba(){
        SMservicio.cargarDatos();
        return "Cargados con exito";
    }
    @GetMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<RespuestaSimpleDTO> seguir(@PathVariable int user_id, @PathVariable int user_id_to_follow) throws UsuarioNoEncontradoError {
        RespuestaSimpleDTO rta = SMservicio.seguir(user_id, user_id_to_follow);
        return new ResponseEntity<>(rta, HttpStatus.OK);
    }
    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<CantidadFollowsDTO> contar(@PathVariable int user_id) throws UsuarioNoEncontradoError {
        CantidadFollowsDTO cantidad = SMservicio.contar(user_id);
        return new ResponseEntity<>(cantidad, HttpStatus.OK);
    }
}
