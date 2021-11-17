package com.SprintI.SocialMeli.services;

import com.SprintI.SocialMeli.dtos.*;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();

    //US 001
    void followUser(int userId, int userIdToFollow);

    //US 007
    void unfollowUser(int userId, int userIdToUnfollow);

    //US 002
    UserCountDTO quantityOfFollowers(int id);

    //US 003
    UserFollowersDTO followers(int id, String order);

    //US 004
    UserFollowedDTO followed(int id, String order);

    //US 005
    void addNewPost(PostWithoutDiscountDTO postWithoutDiscountDTO);

    //US 006
    UserPostDTO listPostTwoWeeksEarly(int id, String order);


}
