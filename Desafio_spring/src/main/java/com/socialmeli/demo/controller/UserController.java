package com.socialmeli.demo.controller;

import com.socialmeli.demo.dto.*;
import com.socialmeli.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements IUserController{

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserDTO> addUser(AddUserDTO addUserDTO) {
        return new ResponseEntity<>(
                this.userService.addUser(addUserDTO),
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<UserFollowedDTO> followUser(Integer userId, Integer userIdToFollow) {
        return new ResponseEntity<>(
                this.userService.followUser(userId, userIdToFollow),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<Void> unfollowUser(Integer userId, Integer userIdToUnfollow) {

        this.userService.unfollowUser(userId, userIdToUnfollow);

        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Integer id) {
        return new ResponseEntity<>(
                this.userService.getUserById(id),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(
                this.userService.getUsers(),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<UserWithFollowersCountDTO> getUserFollowersCount(Integer userId) {
        return new ResponseEntity<>(
                this.userService.getUserFollowersCount(userId),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<UserFollowersDTO> getUserFollowersList(Integer userId, String order) {
        return new ResponseEntity<>(
                this.userService.getUserFollowersList(userId, order),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<UserFollowedDTO> getUserFollowedList(Integer userId, String order) {
        return new ResponseEntity<>(
                this.userService.getUserFollowedList(userId, order),
                HttpStatus.OK
        );
    }
}
