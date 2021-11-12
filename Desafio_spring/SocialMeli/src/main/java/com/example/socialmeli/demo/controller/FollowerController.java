package com.example.socialmeli.demo.controller;



import com.example.socialmeli.demo.dto.controllerToService.FollowUserDTO;
import com.example.socialmeli.demo.dto.controllerToService.UserIdDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowerCountDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowersList;
import com.example.socialmeli.demo.service.IFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FollowerController {

    @Autowired
    IFollowerService iFollowerService;

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity followUser(@PathVariable int user_id, @PathVariable int user_id_to_follow){

    FollowUserDTO request = new FollowUserDTO();
    request.setUser_id(user_id);
    request.setUser_id_to_follow(user_id_to_follow);

    return iFollowerService.seguirUsuario(request);
    }


//US 0002
    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<UserFollowerCountDTO> getFollowerCountByUserId(@PathVariable int user_id){

        UserFollowerCountDTO response = new UserFollowerCountDTO();

        UserIdDTO request = new UserIdDTO();
        request.setUser_id(user_id);

        response = iFollowerService.getFollowersCountByUserID(request);

        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    //US 0003
    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<UserFollowersList> getFollowersListByUserId(@PathVariable int user_id){

        UserFollowersList response = new UserFollowersList();

        UserIdDTO request = new UserIdDTO();
        request.setUser_id(user_id);

        response = iFollowerService.getFollowersListByUserID(request);

        return new ResponseEntity<>(response,HttpStatus.OK);

    }




}
