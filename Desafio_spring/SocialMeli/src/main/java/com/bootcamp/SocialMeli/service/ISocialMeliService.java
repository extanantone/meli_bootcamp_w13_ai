package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.CountDTO;
import com.bootcamp.SocialMeli.dto.FollowedDTO;
import com.bootcamp.SocialMeli.dto.FollowerDTO;
import com.bootcamp.SocialMeli.dto.PublicationDTO;
import com.bootcamp.SocialMeli.model.Publication;

public interface ISocialMeliService {

    void newFollow(Integer user_id, Integer user_id_to_follow);
    CountDTO followerCount(Integer user_id);
    FollowerDTO followerList(Integer user_id);
    FollowedDTO followedList(Integer user_id);
    Publication newPublication(PublicationDTO publicationDTO);
    PublicationDTO recentPublication(Integer user_id, String order);
    void deleteFollow(Integer user_id, Integer user_id_to_unfollow);


}
