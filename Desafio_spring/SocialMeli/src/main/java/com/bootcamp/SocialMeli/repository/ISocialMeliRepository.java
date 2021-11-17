package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Publication;
import com.bootcamp.SocialMeli.model.User;

import java.util.List;

public interface ISocialMeliRepository {
    void newFollow(Integer user_id, Integer user_id_to_follow);
    User userId(Integer user_id);
    List<User> followerList(Integer user_id);
    List<User> followedList (Integer user_id);
    Publication createPublication(Publication publication);
    List<Publication> recentPublication(Integer user_id);
    void deleteFollow(Integer user_id, Integer user_id_to_unfollow);
}
