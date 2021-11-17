package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(path = "/users")
public class UsersController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/{user_id}/follow/{user_id_follow}")
    public ResponseEntity<SeguidorDTO> postfollow(@PathVariable int user_id, @PathVariable int user_id_follow){
        return new ResponseEntity<>( iUserService.setSeguidor(user_id,user_id_follow), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<MesiguenCabtidadDTO> getfollowers(@PathVariable int user_id){
        return new ResponseEntity<>(iUserService.getSequidores(user_id),HttpStatus.OK);
    }

    @PostMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<SeguidorDTO> unfollow(@PathVariable int user_id, @PathVariable int user_id_to_unfollow){
        return  new ResponseEntity<>(iUserService.dejarDeSeguir(user_id,user_id_to_unfollow),HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<MesiguenDTO> getfollowersList(@PathVariable int user_id ,@RequestParam(required = false) String order){
        if(order != null)
            return new ResponseEntity<>(iUserService.getOrdenadaMesiguen(user_id,order),HttpStatus.OK);
        else
            return new ResponseEntity<>(iUserService.getMeSiguen(user_id),HttpStatus.OK);

    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<MesiguenDTO> getfollowed(@PathVariable int user_id,@RequestParam(required = false) String order){
        if(order==null)
            return new ResponseEntity<>(iUserService.getAquienSiguo(user_id),HttpStatus.OK);
        else
            return new ResponseEntity<>(iUserService.getOrdenadaAquienSigo(user_id,order),HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<List<UserDTO>> setUSer(@RequestBody List<UserDTO> userDTOs){
        return new ResponseEntity<>(iUserService.setUser(userDTOs),HttpStatus.OK);
    }
}
