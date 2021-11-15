package com.bootcamp.socialmeli.service;

import org.springframework.http.ResponseEntity;

public interface IServiceFollower {

    ResponseEntity userToFollow(int userId, int userIdToFollow);

    ResponseEntity getCountFollowersOfuser(int idUser);

    ResponseEntity getFollowersFromUser(int idUser, String order);

    ResponseEntity userToUnfollow(int userId, int userIdToUnfollow);

}
