package com.sprint.SocialMeli.repository;

import com.sprint.SocialMeli.model.Post;
import com.sprint.SocialMeli.model.User;

public interface ISocialRepository {
    boolean existsUser(int userId);
    boolean existsPost(int postId);
    User getUser(int userId);
    void createUser(User user);
    void createPost(Post post);
    Post getPost(int idPost);
}
