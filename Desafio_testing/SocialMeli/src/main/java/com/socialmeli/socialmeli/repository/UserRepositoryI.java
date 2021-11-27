package com.socialmeli.socialmeli.repository;

import com.socialmeli.socialmeli.model.User;

public interface UserRepositoryI {

    String addFollow(int user_id,int user_id_to_follow);
    User getUser(int user_id);
    boolean userExists(int user_id);
    void addPost(int user_id,int post_id);
    String getUserName(int user_id);
    String unfollow(int user_id, int user_id_to_unfollow);
}
