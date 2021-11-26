package com.lgoyenechea.socialmeli.service;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.exception.UserNotFoundException;
import com.lgoyenechea.socialmeli.exception.UserNotFollowException;

public interface IUserService {

    UserDTO save(UserCreationDTO newUser);

    UserFollowDTO follow(Long userId, Long userIdToFollow) throws UserNotFoundException;

    UserFollowersCountDTO followersCount(Long userId) throws UserNotFoundException;

    UserFollowersListDTO followersList(Long userId, String order) throws UserNotFoundException;

    UserFollowedListDTO followedList(Long userId, String order) throws UserNotFoundException;

    UserUnfollowDTO unfollow(Long userId, Long userIdToUnfollow) throws UserNotFollowException;
}
