package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class SocialMeliRepository implements ISocialMeliRepository {
    private final ArrayList<User> users;

    public SocialMeliRepository() {
        this.users = new ArrayList<>();

        users.add(new User(1, "Usuario Nº1"));
        users.add(new User(2, "Usuario Nº2"));
        users.add(new User(3, "Usuario Nº3"));
        users.add(new User(4, "Usuario Nº4"));
    }

    @Override
    public Optional<User> findUser(int userId) {
        User user;

        try {
            user = users.get(userId - 1);
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }

        return Optional.of(user);
    }
}