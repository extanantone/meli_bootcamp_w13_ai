package com.socialMeli.SocialMeli.service;

import com.socialMeli.SocialMeli.repository.UserRepository;
import com.socialMeli.SocialMeli.userDto.FollowedListDTO;
import com.socialMeli.SocialMeli.userDto.FollowersListDTO;
import com.socialMeli.SocialMeli.userDto.UserFollowDTO;
import com.socialMeli.SocialMeli.userDto.UserFollowersCountDTO;

public interface UserService {
    UserFollowDTO follow(Integer user_id, Integer user_to_follow_id);
    UserFollowersCountDTO countFollowers(Integer user_id);
    FollowersListDTO listFollowers(Integer user_id);
    FollowersListDTO listFollowers(Integer user_id,String order);
    FollowedListDTO listFollowed(Integer user_id);
    FollowedListDTO listFollowed(Integer user_id, String order);
    UserRepository getUserRepository();

    UserFollowDTO unfollow(Integer user_id, Integer user_id_to_follow);


}
