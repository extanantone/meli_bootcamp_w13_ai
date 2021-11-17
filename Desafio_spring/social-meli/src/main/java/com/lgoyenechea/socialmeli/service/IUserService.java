package com.lgoyenechea.socialmeli.service;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.exception.UserArgumentNotValidException;
import com.lgoyenechea.socialmeli.exception.UserDoesNotExistsException;
import com.lgoyenechea.socialmeli.exception.UserDoesNotFollowException;

public interface IUserService {

    UserDTO save(UserCreationDTO newUser);

    UserFollowDTO follow(Long userId, Long userIdToFollow) throws UserDoesNotExistsException;

    UserFollowersCountDTO followersCount(Long userId) throws UserDoesNotExistsException;

    UserFollowersListDTO followersList(Long userId, String order) throws UserDoesNotExistsException;

    UserFollowedListDTO followedList(Long userId, String order) throws UserDoesNotExistsException;

    UserUnfollowDTO unfollow(Long userId, Long userIdToUnfollow)
            throws UserArgumentNotValidException, UserDoesNotFollowException;
}
