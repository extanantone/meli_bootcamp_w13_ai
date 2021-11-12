package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Buyer;
import com.bootcamp.SocialMeli.model.Seller;
import com.bootcamp.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository{
    Map<Integer, User> users;

    @Override
    public Optional<User> find(int userId) {
        if (!this.users.containsKey(userId)) return Optional.empty();
        return Optional.of(this.users.get(userId));

    }

    @Override
    public List<User> findAll() {
        return new ArrayList(this.users.values());
    }

    public User create(int userId, String userName, boolean isSeller) {
        User user;
        if (isSeller) user = new Seller(userId, userName);
        else user = new Buyer(userId, userName);
        this.users.put(userId, user);
        return user;
    }
}
