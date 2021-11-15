package com.example.socialmeli.demo.service;


import com.example.socialmeli.demo.dto.controllerToService.FollowUserDTO;
import com.example.socialmeli.demo.dto.controllerToService.RequestUserListDTO;
import com.example.socialmeli.demo.dto.controllerToService.UnfollowUserDTO;
import com.example.socialmeli.demo.dto.controllerToService.UserIdDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowerCountDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowersListDTO;
import org.springframework.http.ResponseEntity;


public interface IFollowerService {

    public ResponseEntity followUser(FollowUserDTO requestDTO);

    public UserFollowerCountDTO getFollowersCountByUserID(UserIdDTO request);

    public UserFollowersListDTO getFollowersListByUserID(RequestUserListDTO request);

    public UserFollowersListDTO getFollowedUsersFromUserId(RequestUserListDTO request);

    public ResponseEntity unFollowUser(UnfollowUserDTO request);



}
