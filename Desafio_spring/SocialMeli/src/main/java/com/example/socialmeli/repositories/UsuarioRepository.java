package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository("UserRepository")
public class UsuarioRepository implements IRepository<User> {

    List<User> users;

    public UsuarioRepository(){this.users = loadRepository();}

    @Override
    public User getById(Integer id) throws UserNotFoundException {

        return users.stream().filter(us -> us.getUserId().equals(id)).findFirst().orElseThrow(() -> new UserNotFoundException(id));

    }

    @Override
    public List<User> getAll(){
        return this.users;
    }

    @Override
    public void push(User newElement) {
        this.users.add(newElement);
    }

    @Override
    public void removeById(Integer id) {
        users.forEach(user -> user.getFollowersId().removeIf( idFollower -> idFollower.equals(id )));
        users.removeIf(user -> user.getUserId().equals(id));
    }

    @Override
    public List<User> loadRepository(){

        List<User> userJson = null;

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:usersSocialMeli.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};

        try {
            userJson = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userJson;

    }
}
