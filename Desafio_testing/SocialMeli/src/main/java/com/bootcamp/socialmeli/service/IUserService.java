package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.UserFollowedDTO;
import com.bootcamp.socialmeli.dto.UserFollowersDTO;
import com.bootcamp.socialmeli.dto.UserTotalFollowersDTO;
import com.bootcamp.socialmeli.exception.NotFoundUserException;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;

import java.util.List;

public interface IUserService {

    void followUser(int userId, int userToFollowId) throws NotPossibleOperationException;

    UserTotalFollowersDTO getTotalUserFollowers(int id) throws NotPossibleOperationException;

    UserFollowersDTO getUsersFollowers(int id, String order) throws NotPossibleOperationException;

    UserFollowedDTO getUsersFollowed(int id, String order) throws NotPossibleOperationException;

    void unfollowUser(int userId, int userToUnfollowId) throws NotPossibleOperationException;


}
