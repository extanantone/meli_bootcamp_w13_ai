package com.Sprint1.SocialMeli.service;

import com.Sprint1.SocialMeli.dto.FollowCountDTO;
import com.Sprint1.SocialMeli.dto.FollowListDTO;

public interface IUserService {
    void followSeller(int user_id, int user_id_to_follow);
    public FollowCountDTO followerCount(int user_id);
    public FollowListDTO followerList(int user_id);


}
