package com.bootcamp.SocialMeli.Controller;

import com.bootcamp.SocialMeli.DTO.SeguidorDTO;
import com.bootcamp.SocialMeli.DTO.SeguidoresCountDTO;
import com.bootcamp.SocialMeli.Model.Seguidor;
import com.bootcamp.SocialMeli.Service.ISocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping(path ="/users")
public class UsuarioController {

    @Autowired
    ISocialService iSocialService;

    //Seguir a un usuario/vendedor
    @PostMapping("/{userId}/follow/{userIdFollow}")
    public ResponseEntity<SeguidorDTO> Follow(@PathVariable int userId, @PathVariable Integer userIdFollow){
        Seguidor seguidor = new Seguidor();
        seguidor.setIdUser(userId);
        seguidor.setIdUserFollow(userIdFollow);
        return new ResponseEntity<>( iSocialService.postSeguidor(seguidor), HttpStatus.OK);
    }

    //Dejar de seguir un usuario/vendedor
    @PutMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<SeguidorDTO> unFollow(@PathVariable int userId, @PathVariable Integer userIdToUnfollow){
        Seguidor seguidor = new Seguidor();
        seguidor.setIdUser(userId);
        seguidor.setIdUserFollow(userIdToUnfollow);
        return  new ResponseEntity<>(iSocialService.unFollow(seguidor),HttpStatus.OK);
    }

    //contar cuantos seguidores tiene un usuario
    @GetMapping("{userId}/followers/count")
    public ResponseEntity<SeguidoresCountDTO> getCuentaSeguidores(@PathVariable Integer userId){
        return new ResponseEntity<>(iSocialService.getSequidores(userId),HttpStatus.OK);
    }

    //Traer lista de seguidores de un usuario
    @GetMapping("{userId}/followers/list")
    public ResponseEntity<SeguidoresCountDTO> getMisSeguidores(@PathVariable Integer userId){
        return new ResponseEntity(iSocialService.getFollowers(userId),HttpStatus.OK);
    }

    //Traer lista de a quien sigue un usuario
    @GetMapping("{userId}/followed/list")
    public ResponseEntity<SeguidoresCountDTO> getMisSeguidos(@PathVariable Integer userId){
        return new ResponseEntity(iSocialService.getFollowed(userId),HttpStatus.OK);
    }

    //Trae lista ordenada de mis seguidores
    @GetMapping("{userId}/followers/listorder")
    public ResponseEntity<SeguidorDTO> getOrderFollowers(@PathVariable Integer userId ,@PathParam("order") String order){
        return new ResponseEntity(iSocialService.getOrderFollow(userId,order),HttpStatus.OK);
    }
    //Trae lista ordenada de los que sigo
    @GetMapping("{userId}/followed/listorder")
    public ResponseEntity<SeguidorDTO> getfollowed(@PathVariable Integer userId,@PathParam("order") String order){
        return new ResponseEntity(iSocialService.getOrderFollowed(userId,order),HttpStatus.OK);
    }
}
