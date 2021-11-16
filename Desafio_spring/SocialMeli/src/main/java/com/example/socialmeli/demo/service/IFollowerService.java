package com.example.socialmeli.demo.service;


import com.example.socialmeli.demo.dto.controllerToService.DTOFollowUser;
import com.example.socialmeli.demo.dto.controllerToService.DTORequestUserList;
import com.example.socialmeli.demo.dto.controllerToService.DTOUnfollowUser;
import com.example.socialmeli.demo.dto.controllerToService.DTOUserId;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserFollowerCount;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserFollowersList;
import org.springframework.http.ResponseEntity;


public interface IFollowerService {

    public ResponseEntity followUser(DTOFollowUser requestDTO);

    public DTOUserFollowerCount getFollowersCountByUserID(DTOUserId request);

    public DTOUserFollowersList getFollowersListOfUserID(DTORequestUserList request);

    public DTOUserFollowersList getFollowedUsersOfUserId(DTORequestUserList request);

    public ResponseEntity unFollowUser(DTOUnfollowUser request);



}
