package com.example.socialmeli.demo.service;


import com.example.socialmeli.demo.dto.controllerToService.FollowUserDTO;
import com.example.socialmeli.demo.dto.controllerToService.UnfollowerDTO;
import com.example.socialmeli.demo.dto.controllerToService.UserIdDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowerCountDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowersListDTO;
import org.springframework.http.ResponseEntity;


public interface IFollowerService {

    public ResponseEntity followUser(FollowUserDTO requestDTO);

    public UserFollowerCountDTO getFollowersCountByUserID(UserIdDTO request);

    public UserFollowersListDTO getFollowersListByUserID(UserIdDTO request);

    public UserFollowersListDTO getFollowedUsersFromUserId(UserIdDTO request);

    public ResponseEntity unFollowUser(UnfollowerDTO request);



}
