package com.bootcamp.SocialMeli.Controller;

import com.bootcamp.SocialMeli.DTO.SeguidorDTO;
import com.bootcamp.SocialMeli.DTO.SeguidoresCountDTO;
import com.bootcamp.SocialMeli.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path ="/users")
public class UsuarioController {

    @Autowired
    IUsuarioService iUsuarioService;

    //Seguir a un usuario/vendedor
    @GetMapping("/{userId}/follow/{userIdFollow}")
    public ResponseEntity<SeguidorDTO> getUsuarioASeguir(@PathVariable int userId, @PathVariable int userIdFollow){
        return new ResponseEntity<>( iUsuarioService.setSeguidor(userId, userIdFollow), HttpStatus.OK);
    }

    //contar cuantos seguidores tiene un usuario
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SeguidoresCountDTO> getCuentaSeguidores(@PathVariable int userId){
        return new ResponseEntity<>(iUsuarioService.getSequidores(userId),HttpStatus.OK);
    }

    //Traer lista de seguidores de un usuario
    @GetMapping("{userId}/followers/list")
    public ResponseEntity<SeguidoresCountDTO> getMisSeguidores(@PathVariable int userId){
        return new ResponseEntity(iUsuarioService.getFollowers(userId),HttpStatus.OK);
    }

    //Traer lista de a quien sigue un usuario
    @GetMapping("{userId}/followed/list")
    public ResponseEntity<SeguidoresCountDTO> getMisSeguidos(@PathVariable int userId){
        return new ResponseEntity(iUsuarioService.getFollowed(userId),HttpStatus.OK);
    }
}
