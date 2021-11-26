package com.bootcamp.socialmeli.service;

import org.springframework.http.ResponseEntity;

public interface IServiceFollowed {

    ResponseEntity getFolloweds(int userId, String order);

    ResponseEntity getPostFollowed(int userId, String order);

}
