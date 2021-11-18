package com.example.socialmeli.repositories;

import com.example.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository("UserRepository")
public class UsuarioRepository implements IRepository<User> {

    List<User> users;

    public UsuarioRepository(){
        this.users = loadFromFile("classpath:usersSocialMeli.json");
    }
    public static List<User>  loadFromFile(String path) {

        List<User> loadedData = null;

        File file = null;
        try {
            file = ResourceUtils.getFile(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};

        try {
            loadedData = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedData;

    }

    @Override
    public Optional<User> findId(Integer id) {
        return users.stream()
                .filter(us -> us.getUserId().equals(id))
                .findFirst();

    }

    @Override
    public List<User> findAll(){
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

}
