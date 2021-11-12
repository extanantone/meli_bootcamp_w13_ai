package com.bootcamp.socialmeli.service;


import org.springframework.http.ResponseEntity;

public interface IServiceFollower {

    ResponseEntity userToFollow(int idUser, int idUserToFollow);

    ResponseEntity getCountFollowersOfuser(int idUser);

    ResponseEntity getFollowersFromUser(int idUser);

}
