package com.sprint.SocialMeli.repository;

import com.sprint.SocialMeli.model.User;

public interface ISocialRepository {
    boolean existsUser(int user_id);
    boolean existsPost(int post_id);
    User getUser(int user_id);
    void putUser(User user);
    void putPost(User user);
}
