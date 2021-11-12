package com.example.socialmeli.demo.service;


import com.example.socialmeli.demo.dto.controllerToService.FollowUserDTO;
import com.example.socialmeli.demo.dto.controllerToService.UserIdDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowerCountDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserFollowersList;
import org.springframework.http.ResponseEntity;


public interface IFollowerService {

    public ResponseEntity seguirUsuario(FollowUserDTO requestDTO);

    public UserFollowerCountDTO getFollowersCountByUserID(UserIdDTO request);

    public UserFollowersList getFollowersListByUserID(UserIdDTO request);



}
