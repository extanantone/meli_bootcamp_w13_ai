package com.bootcamp.socialmeli.controller;


import com.bootcamp.socialmeli.dto.response.user.PurchaserFollowedListDTO;
import com.bootcamp.socialmeli.dto.response.user.SellerFollowersInfoDTO;
import com.bootcamp.socialmeli.dto.response.user.SellerFollowersListDTO;
import com.bootcamp.socialmeli.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final IUserService service;

    public UsersController(IUserService service) {
        this.service = service;
    }

    @PostMapping(path = "/{user_id}/follow/{user_id_to_follow}" )
    public ResponseEntity<String> follow(@PathVariable Integer user_id,
                                    @PathVariable Integer user_id_to_follow)
    {
        service.addFollowed(user_id,user_id_to_follow);
        return ResponseEntity
                .ok("El comprador con id:" + user_id + " ahora sigue al vendedor con id:" + user_id_to_follow);
    }

    @GetMapping(path = "/{user_id}/followers/count")
    public ResponseEntity<SellerFollowersInfoDTO> getSellerFollowersInfo(@PathVariable Integer user_id){
        return  ResponseEntity.ok(service.getSellerFollowersCount(user_id));
    }

    @GetMapping(path = "/{user_id}/followers/list")
    public ResponseEntity<SellerFollowersListDTO> getSellerFollowersList(@PathVariable Integer user_id){
        return  ResponseEntity.ok(service.getSellerFollowersList(user_id));
    }

//    /users/{user_id}/followed/list

    @GetMapping(path = "/{user_id}/followed/list")
    public ResponseEntity<PurchaserFollowedListDTO> getPurcharserFollowedList(@PathVariable Integer user_id){
        return ResponseEntity.ok(service.getPurchaserFollowedList(user_id));
    }

}
