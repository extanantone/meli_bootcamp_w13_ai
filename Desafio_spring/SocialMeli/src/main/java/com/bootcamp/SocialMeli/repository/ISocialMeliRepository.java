package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Publication;
import com.bootcamp.SocialMeli.model.User;

public interface ISocialMeliRepository {

    void addNewFollower(Integer user_id, Integer user_id_to_follow);

    void addNewFollowed(Integer user_id, Integer user_id_to_follow);

    User userId(Integer user_id);

    boolean findUser(Integer user_id);

    Publication createPublication(Publication publication);

    void deleteFollower(Integer user_id, Integer user_id_to_unfollow);

    void deleteFollowed(Integer user_id, Integer user_id_to_unfollow);
}
