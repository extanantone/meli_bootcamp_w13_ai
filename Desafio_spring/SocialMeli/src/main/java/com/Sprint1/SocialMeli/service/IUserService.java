package com.Sprint1.SocialMeli.service;

import com.Sprint1.SocialMeli.dto.FollowCountDTO;
import com.Sprint1.SocialMeli.dto.FollowedListDTO;
import com.Sprint1.SocialMeli.dto.FollowersListDTO;

public interface IUserService {
    void followSeller(int user_id, int user_id_to_follow);
    FollowCountDTO followerCount(int user_id);
    FollowersListDTO followerList(int user_id, String order);
    FollowedListDTO followedList(int user_id, String order);
    void unfollowSeller(int user_id, int user_id_to_follow);
}
