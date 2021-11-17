package com.bootcamp.SocialMeli.service.user;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.dto.user.*;

public interface IUserService {
    ResponseDTO follow(int userId, int userIdToFollow);

    ResponseDTO unfollow(int userId, int userIdToUnfollow);

    UserFollowersCountDTO followersCount(int userId);

    UserFollowersListDTO followersList(int userId, String order);

    UserFollowedListDTO followedList(int userId, String order);
}