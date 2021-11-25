package com.example.socialmeli.demo.controller;



import com.example.socialmeli.demo.dto.controllerToService.DTOFollowUser;
import com.example.socialmeli.demo.dto.controllerToService.DTORequestUserList;
import com.example.socialmeli.demo.dto.controllerToService.DTOUnfollowUser;
import com.example.socialmeli.demo.dto.controllerToService.DTOUserId;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserFollowedList;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserFollowerCount;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserFollowersList;
import com.example.socialmeli.demo.service.IFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
public class FollowerController {

    @Autowired
    IFollowerService iFollowerService;

    //US 0001: seguir a un usuario
    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity followUser(    @PathVariable int user_id,
                                         @PathVariable int user_id_to_follow)
    {
    @Valid DTOFollowUser request = new DTOFollowUser();
    request.setUserId(user_id);
    request.setUserIdToFollow(user_id_to_follow);

    return iFollowerService.followUser(request);

    }


    //US 0002: cantidad de seguidores de un usuario
    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<DTOUserFollowerCount> getFollowerCountByUserId(@PathVariable int user_id){

        DTOUserFollowerCount response = new DTOUserFollowerCount();
        DTOUserId request = new DTOUserId();
        request.setUserId(user_id);

        response = iFollowerService.getFollowersCountByUserID(request);

        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    //US 0003: Quien me sigue y US 0008
    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<DTOUserFollowersList> getUsersWhoFollowsMeByUserId(@PathVariable int user_id,
                                                                             @RequestParam(value = "order", required = false) String order){

        DTOUserFollowersList response = new DTOUserFollowersList();
        DTORequestUserList request = new DTORequestUserList();
        request.setUserId(user_id);
        request.setOrder(order);

        response = iFollowerService.getFollowersListOfUserID(request);

        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    //US 0004: ¿A quien sigo? Y US 0008
    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<DTOUserFollowedList> getFollowedUsersFromUserId(@PathVariable int user_id,
                                                                          @RequestParam(value = "order", required = false) String order){

        DTOUserFollowedList response = new DTOUserFollowedList();

        DTORequestUserList request = new DTORequestUserList();
        request.setUserId(user_id);
        request.setOrder(order);

        response = iFollowerService.getFollowedUsersOfUserId(request);

        return new ResponseEntity<>(response,HttpStatus.OK);

    }


    //US 0007: Dejar de seguir a un usuario
    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity unFollowUser(@PathVariable int user_id, @PathVariable int user_id_to_unfollow){

        DTOUnfollowUser request = new DTOUnfollowUser();
        request.setUserId(user_id);
        request.setUserIdToUnfollow(user_id_to_unfollow);

        return iFollowerService.unFollowUser(request);

    }




}
