package com.socialmeli.repository;
import com.socialmeli.model.Post;
import com.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {
    User getUserById(int id);
    List<User> followedUser(User user);
    List<Post> getPostLastTwoWeeksOfFollowed(int idUser);

    List<Post> getPromoPostByUserId(int userId);

    User findUserByEmail(String email);

    void save(User created);

    List<User> findAll();

    List<User> findAllSellers();
}
