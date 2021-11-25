package com.socialMeli.SocialMeli.repository;

import com.socialMeli.SocialMeli.userDto.FollowedListDTO;
import com.socialMeli.SocialMeli.userDto.FollowersListDTO;
import com.socialMeli.SocialMeli.userDto.UserFollowDTO;
import com.socialMeli.SocialMeli.userDto.UserFollowersCountDTO;
import com.socialMeli.SocialMeli.model.User;

import java.util.HashMap;

public interface UserRepository {

    HashMap<Integer, User> getList_users();
    void loadUsers();
    UserFollowDTO follow(Integer user_id, Integer user_to_follow_id);

    UserFollowersCountDTO countFollowers(Integer user_id);

    FollowersListDTO listFollowers(Integer user_id);

    FollowedListDTO listFollowed(Integer user_id);

    UserFollowDTO unfollow(Integer user_id, Integer user_id_to_unfollow);
}
