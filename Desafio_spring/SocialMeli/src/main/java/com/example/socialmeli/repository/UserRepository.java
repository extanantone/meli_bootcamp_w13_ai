package com.example.socialmeli.repository;

import com.example.socialmeli.exception.UserIdNotFoundException;
import com.example.socialmeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository implements IUserRepository{

    Map<Integer, User> users = new HashMap<>();

    public UserRepository() {
        users.put(1, new User(1, "Pepe"));
        users.put(2, new User(2, "Pepa"));
        users.put(3, new User(3, "Popa"));
        users.put(4, new User(4, "Pepa Pig"));
        users.put(5, new User(5, "Pig Pepa"));
        users.put(6, new User(6, "Pepe Pan"));
        users.put(7, new User(7, "Pan Pepe"));
        users.put(8, new User(8, "Salt Pepper"));
    }

    @Override
    public Set<Map.Entry<Integer, User>> findAll() {
        return users.entrySet();
    }

    @Override
    public User find(Integer id) {
        if (users.containsKey(id)) {
            return users.get(id);
        }
        throw new UserIdNotFoundException(id);
    }

}
