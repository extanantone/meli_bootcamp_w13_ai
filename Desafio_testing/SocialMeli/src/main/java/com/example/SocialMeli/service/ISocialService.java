package com.example.SocialMeli.service;

import com.example.SocialMeli.dto.*;
import com.example.SocialMeli.model.User;

import java.util.List;

public interface ISocialService {

    void followUser(int userId, int userIdToFollow);
    UserDataDto countFollowers(int userId);
    UserFollowDto listFollowers(int userId, String order);
    UserFollowDto listFollowed(int userId, String order);
    void postPublication (PublicationDto publicationDto);
    UserDto getProductsFollowed(int userId, String order);
    void unfollowUser(int userId, int userIdToUnfollow);
    UserCountPromoDto countPromoPublications(int userId);
    UserDto getPublicationsPromo(int userId, String order);
    User getUserById(int id);
    List<User> getUsers();
    //User getUser(int user_id);

}
