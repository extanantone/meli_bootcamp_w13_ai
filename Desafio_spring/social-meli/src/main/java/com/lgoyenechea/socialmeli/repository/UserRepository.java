package com.lgoyenechea.socialmeli.repository;

import com.lgoyenechea.socialmeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IRepository<Long, User> {

    private final List<User> users = new ArrayList<>();
    private long idCounter = 1;

    @Override
    public User save(User user) {
        setId(user);
        users.add(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return users.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    private void setId(User user) {
        user.setId(idCounter);
        idCounter++;
    }
}
