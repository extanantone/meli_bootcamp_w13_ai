package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.CountDTO;
import com.bootcamp.SocialMeli.dto.FollowedDTO;
import com.bootcamp.SocialMeli.dto.FollowerDTO;
import com.bootcamp.SocialMeli.dto.PublicationDTO;

public interface ISocialMeliService {

    void addNewFollow(Integer user_id, Integer user_id_to_follow);

    CountDTO followerCount(Integer user_id);

    FollowerDTO followerList(Integer user_id);

    FollowedDTO followedList(Integer user_id);

    void newPublication(PublicationDTO publicationDTO);

    void deleteFollow(Integer user_id, Integer user_id_to_unfollow);


}
