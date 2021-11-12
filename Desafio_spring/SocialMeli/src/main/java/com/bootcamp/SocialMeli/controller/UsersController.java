package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.SeguidorDTO;
import com.bootcamp.SocialMeli.service.IUserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/users")
public class UsersController {


    @Autowired
    IUserService iUserService;

    @GetMapping("/{user_id}/follow/{user_id_follow}")
    public ResponseEntity<SeguidorDTO> getid(@PathVariable int user_id, @PathVariable int user_id_follow){


        return new ResponseEntity<>( iUserService.setSeguidor(user_id,user_id_follow), HttpStatus.OK);
    }
}
