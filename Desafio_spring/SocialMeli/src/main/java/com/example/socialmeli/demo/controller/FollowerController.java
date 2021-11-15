package com.example.socialmeli.demo.controller;



import com.example.socialmeli.demo.dto.controllerToService.FollowUserDTO;
import com.example.socialmeli.demo.dto.controllerToService.RequestUserListDTO;
import com.example.socialmeli.demo.dto.controllerToService.UnfollowUserDTO;
import com.example.socialmeli.demo.dto.controllerToService.UserIdDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowerCountDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowersListDTO;
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

    return iFollowerService.followUser(request);
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
    public ResponseEntity<UserFollowersListDTO> getFollowersListByUserId(@PathVariable int user_id,
                                                                         @RequestParam(value = "order", required = false) String order){

        UserFollowersListDTO response = new UserFollowersListDTO();
        RequestUserListDTO request = new RequestUserListDTO();
        request.setUserId(user_id);
        request.setOrder(order);

        response = iFollowerService.getFollowersListByUserID(request);

        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    //US 0004
    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<UserFollowersListDTO> getFollowedUsersFromUserId(@PathVariable int user_id,
                                                                           @RequestParam(value = "order", required = false) String order){

        UserFollowersListDTO response = new UserFollowersListDTO();

        RequestUserListDTO request = new RequestUserListDTO();
        request.setUserId(user_id);
        request.setOrder(order);

        response = iFollowerService.getFollowedUsersFromUserId(request);

        return new ResponseEntity<>(response,HttpStatus.OK);

    }





    //US 0007
    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity unFollowUser(@PathVariable int user_id, @PathVariable int user_id_to_unfollow){

        UnfollowUserDTO request = new UnfollowUserDTO();
        request.setUser_id(user_id);
        request.setUser_id_to_unfollow(user_id_to_unfollow);

        try{
            iFollowerService.unFollowUser(request);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }




}
