package com.bootcamp.SocialMeli.Controller;

import com.bootcamp.SocialMeli.DTO.Errores.ErrorDTO;
import com.bootcamp.SocialMeli.DTO.PublicUserDTO;
import com.bootcamp.SocialMeli.DTO.PublicacionDTO;
import com.bootcamp.SocialMeli.Service.ISocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
public class PublicacionController {
    @Autowired
    ISocialService iSocialService;

    @PostMapping("/post")
    public ResponseEntity<PublicUserDTO> addNewPublic(@RequestBody PublicacionDTO newPost){
        iSocialService.setPublicacion(newPost);
        ErrorDTO msg=new ErrorDTO("Post agregado!");
        return new ResponseEntity(msg,HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PublicUserDTO> getPublic(@PathVariable Integer userId, @RequestParam(required = false) String order){
        if(order == null) {
            return new ResponseEntity<>(iSocialService.getPublicacionesRecientes(userId,order),HttpStatus.OK);
        }
        return new ResponseEntity<>(iSocialService.getPubliOrderByFecha(userId,order),HttpStatus.OK);
    }
}
