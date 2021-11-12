package com.SocialMeli.Sprint1SocialMeli.Controller;


import com.SocialMeli.Sprint1SocialMeli.Service.ISocialMeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialMeliController {

    final
    ISocialMeliService service;


    public SocialMeliController(ISocialMeliService service) {
        this.service = service;
    }

    @PostMapping(path = "/users/{user_id}/follow/{user_id_to_follow}" )
    public ResponseEntity<?> follow(@PathVariable Integer user_id,
                                    @PathVariable Integer user_id_to_follow)
    {
        service.addFollowed(user_id,user_id_to_follow);
        return ResponseEntity.ok("Se ha seguido Comprador");
    }


}
